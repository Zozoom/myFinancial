
/**
* Define and Find the elements.
* */
    var element = document.getElementById('quantity');

/**
* Check the elements are not null.
* */
    if(element){
        element.addEventListener('keyup', thousandSeparator, false);
        console.log("Add Event Listener to Quantity element was successful.");
    }
    else{
        console.log("Quantity element cannot find on the page.");
    }

/**
 * The method which make separate the number.
 * */
    function thousandSeparator() {

        if(element.value.length <=12 && element.value != null && element.value !== ""){

            console.log("Size: "+element.value.length);

            element.value = element.value.toString().replace(",","").replace(",","").replace(",","");
            console.log("Before: "+element.value);

            element.value = element.value.toString().replace(new RegExp('\\B(?=(\\d{3})+(?!\\d))', 'g'), ",");
            console.log("After: "+element.value);
        }
        else {
            alert("Quantity value is invalid or the number is too big. (Max number 10 numeric)");
            element.value = "";
        }
    }

/**
 * This method responsible for just numeric format is acceptable.
 * */
    function isNumberKey(evt){
        var charCode = (evt.which) ? evt.which : event.keyCode;
        return (charCode >= 48 && charCode <= 57) || (charCode >= 96 && charCode <= 105);
    }
