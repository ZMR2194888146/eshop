/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


function getCookie(name){
    if(document.cookie.length>0){
    name_index = parseInt(document.cookie.indexOf(name));
        if(name_index !== -1){
            name_start = name_index + name.length + 1;
            name_end = document.cookie.indexOf(";",name_start);
            if (name_end === -1) {
                name_end = document.cookie.length;    
            }  
            return unescape(document.cookie.substring(name_start,name_end));
        }else{
            console.log("no into");
            return false;
        }
    }else{
        return false;
    }
}