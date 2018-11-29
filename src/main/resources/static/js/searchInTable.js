import * as sum from './szum.js';

let $rows = $('#myTable tbody tr');

$('#mySearch').keyup(function() {
    let val = $.trim($(this).val()).replace(/ +/g, ' ').toLowerCase();

    $rows.show().filter(function() {
        let text = $(this).text().replace(/\s+/g, ' ').toLowerCase();
        sum.calculateTableSum("Search-2");
        return !~text.indexOf(val);
    }).hide();

    sum.calculateTableSum("Search-1");

});