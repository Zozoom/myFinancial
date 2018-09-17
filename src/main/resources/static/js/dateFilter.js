
var today = new Date();
var year = today.getFullYear();


const monthNames = ["January", "February", "March", "April", "May", "June",
    "July", "August", "September", "October", "November", "December"];

/**
 * Fill up the page with data. YEAR
 * */
var options = "";
for(var y=year-1; y<=year; y++){
    options += "<option>"+ y +"</option>";
}
document.getElementById("year").innerHTML = options;

/**
 * Fill up the page with data. MONTH
 * */
options = "";
for(var m=0; m<=11; m++){
    options += "<option>"+ monthNames[m] +"</option>";
}
document.getElementById("month").innerHTML = options;

/**
 * Fill up the page with data. DAY
 * */
options = "";
for(var d=1; d<=31; d++){
    options += "<option>"+ d +"</option>";
}
document.getElementById("day").innerHTML = options;


const dateStamp = today.getFullYear() +" / "+ monthNames[today.getMonth()] +" / "+today.getDate();
document.getElementById("dateStamp").innerHTML = "Today is " + dateStamp;