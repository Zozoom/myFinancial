export function calculateTableSum(text) {
    let sum = 0;
    let incomeSum = 0;
    let expenseSum = 0;

    console.log("Msg: " + text);

    let myTableStyle = document.querySelectorAll("#myTable tr");
    myTableStyle.forEach(item => {
        if(item.style.display !== "none"){
            item = item.querySelector("td:nth-child(5) span");
            if(item !== null){
                console.log(item.innerText);
                sum = sum + parseInt(item.innerText);
                parseInt(item.innerText) > 0 ? incomeSum+=parseInt(item.innerText) : expenseSum+=parseInt(item.innerText);
            }
        }
    });
    document.getElementById("allInner").innerText = sum.toString();
    document.getElementById("incomeInner").innerText = incomeSum.toString();
    document.getElementById("expenseInner").innerText = expenseSum.toString();
}

calculateTableSum("start");