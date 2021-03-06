create database [shop];
go
USE [shop];
GO
CREATE TABLE [dbo].[orders](
	[oid] [bigint] IDENTITY(1,1) primary key,
	[uid] [varchar](18) NOT NULL,
	[gid] [varchar](10) NOT NULL,
	[mount] [int] NOT NULL,
	[ispayed] [varchar](1) NOT NULL,
	[date] [date] not NULL default getDate(),
	[money] [money] NULL,
	[paymode] [varchar](20) NULL,
	[payAccount] [varchar](20) NULL,
);
GO
CREATE TABLE [dbo].[goods](
	[gid] [varchar](10) PRIMARY KEY,
	[gname] [nchar](10) NULL,
	[brand] [nchar](10) NULL,
	[model] [varchar](20) NULL,
	[parameter] [varchar](100) NULL,
	[smallphoto] [varchar](20) NULL,
	[largephoto] [varchar](20) NULL,
	[price] [smallmoney] NULL,
	[category] [int] NULL,
);
GO
INSERT [dbo].[goods] VALUES (N'bjb151824', N'联想笔记本电脑   ', N'联想        ', N'bjb151824', N'4核/2G/200G', N'bjb151824_s', N'bjb151824', 6800.0000, 4)
INSERT [dbo].[goods] VALUES (N'bjb152019', N'索尼笔记本电脑   ', N'SONY      ', N'bjb152019', N'6核/3G/300G', N'bjb152019_s', N'bjb152019', 10000.0000, 4)
INSERT [dbo].[goods] VALUES (N'bjb152137', N'华硕笔记本电脑   ', N'ASUS      ', N'bjb152137', N'4核/3G/300G', N'bjb152137_s', N'bjb152137', 8000.0000, 4)
INSERT [dbo].[goods] VALUES (N'bjb152242', N'华硕笔记本电脑   ', N'ASUS      ', N'bjb152242', N'4核/3G/400G', N'bjb152242_s', N'bjb152242', 8500.0000, 4)
INSERT [dbo].[goods] VALUES (N'bjb152419', N'索尼笔记本电脑   ', N'SONY      ', N'bjb152419', N'6核/3G/350G', N'bjb152419_s', N'bjb152419', 10500.0000, 4)
INSERT [dbo].[goods] VALUES (N'bjb152610', N'联想笔记本电脑   ', N'联想        ', N'bjb152610', N'5核/3G/300G', N'bjb152610_s', N'bjb152610', 7500.0000, 4)
INSERT [dbo].[goods] VALUES (N'bjb152717', N'华硕笔记本电脑   ', N'ASUS      ', N'bjb152717', N'4核/2.5G/500G', N'bjb152717_s', N'bjb152717', 9000.0000, 4)
INSERT [dbo].[goods] VALUES (N'sj123136', N'七喜手机      ', N'HEDY      ', N'sj123136', N'3核/3G/500M', N'sj123136_s', N'sj123136', 1800.0000, 3)
INSERT [dbo].[goods] VALUES (N'sj123817', N'MOTOROLA手机', N'MOTOROLA  ', N'sj123817', N'3核/3G/600M', N'sj123817_s', N'sj123817', 2000.0000, 3)
INSERT [dbo].[goods] VALUES (N'sj123929', N'三星手机      ', N'SAMSUNG   ', N'sj123929', N'3核/3G/650M', N'sj123929_s', N'sj123929', 2500.0000, 3)
INSERT [dbo].[goods] VALUES (N'sxj122152', N'SONY摄像机   ', N'SONY      ', N'sxj122152', N'3.5"/2000M/48倍', N'sxj122152_s', N'sxj122152', 12500.0000, 2)
INSERT [dbo].[goods] VALUES (N'sxj122618', N'Canon摄像机  ', N'CANON     ', N'sxj122618', N'4"/3000M/48倍', N'sxj122618_s', N'sxj122618', 15000.0000, 2)
INSERT [dbo].[goods] VALUES (N'xj120912', N'Premier相机 ', N'PREMIER   ', N'xj120912', N'7.0DM-7365/3X Super Zoom', N'xj120912_s', N'xj120912', 1200.0000, 1)
INSERT [dbo].[goods] VALUES (N'xj121208', N'CASIO相机   ', N'CASIO     ', N'xj121208', N'600万像素A700', N'xj121208_s', N'xj121208', 1500.0000, 1)
INSERT [dbo].[goods] VALUES (N'xj121349', N'SAMSUNG相机 ', N'SAMSUNG   ', N'xj121349', N'三星照相机的若干参数', N'xj121349_s', N'xj121349', 1000.0000, 1)
INSERT [dbo].[goods] VALUES (N'xj121618', N'SONY相机    ', N'SONY      ', N'xj121618', N'这是索尼相机的有关参数', N'xj121618_s', N'xj121618', 2000.0000, 1)
INSERT [dbo].[goods] VALUES (N'xj121809', N'FUJIFILM相机', N'FUJIFILM  ', N'xj121809', N'这是FUJIFILM相机的若干参数', N'xj121809_s', N'xj121809', 1600.0000, 1)
INSERT [dbo].[goods] VALUES (N'xj122028', N'OLYMPUS相机 ', N'OLYMPUS   ', N'xj122028', N'有关参数：u760 All-Weather', N'xj122028_s', N'xj122028', 1800.0000, 1)
/****** Object:  Table [dbo].[details]    Script Date: 03/13/2017 21:32:39 ******/
GO
CREATE TABLE [dbo].[details](
	[oid] [bigint] NOT NULL,
	[gid] [varchar](10) NOT NULL,
	[num] [int] NULL,
	[price] [smallmoney] NULL,
    PRIMARY KEY ([oid] ASC,	[gid] ASC)
) ON [PRIMARY]
GO
CREATE TABLE [dbo].[customers](
	[uid] [varchar](18) PRIMARY KEY,
	[uname] [varchar](10) NULL,
	[mobile] [varchar](15) NULL,
	[address] [nchar](20) NULL,
	[password] [varchar](15) NULL,
) ON [PRIMARY]
GO
CREATE TABLE [dbo].[shopingcart](
	[no] [varchar](18) PRIMARY KEY,
	[gid] [varchar](10) NOT NULL,
	[uid] [varchar](18) NOT NULL,
	[num] [int] NOT NULL
)
GO
CREATE TABLE [dbo].[categories](
	[cid] [int] IDENTITY(1,1) PRIMARY KEY,
	[category] [varchar](20) NULL,
) ON [PRIMARY]
GO
SET IDENTITY_INSERT [dbo].[categories] ON
INSERT [dbo].[categories] ([cid], [category]) VALUES (1, N'照相机')
INSERT [dbo].[categories] ([cid], [category]) VALUES (2, N'摄像机')
INSERT [dbo].[categories] ([cid], [category]) VALUES (3, N'手机')
INSERT [dbo].[categories] ([cid], [category]) VALUES (4, N'笔记本电脑')
SET IDENTITY_INSERT [dbo].[categories] OFF
