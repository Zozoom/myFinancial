
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
        if(isNumberKey(element) && element.value != null || !isNaN(element.value)){
            element.value = element.value.toString().replace(",", "");
            element.value = element.value.toString().replace(/\B(?=(\d{3})+(?!\d))/g, ",");
        }
        else {
            element.value = 0;
        }
    }

/**
 * This method responsible for just numeric format is acceptable.
 * */
    function isNumberKey(evt){
        var charCode = (evt.which) ? evt.which : event.keyCode;
        return !(charCode > 31 && (charCode < 48 || charCode > 57));
    }
