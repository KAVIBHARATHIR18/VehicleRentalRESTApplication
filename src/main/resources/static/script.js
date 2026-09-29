const API = "/api";


// ==========================================
// COMMON FUNCTIONS
// ==========================================

function loading() {

    document.getElementById("output").innerHTML = `
        <div class="loading">
            ⏳ Loading data...
        </div>
    `;
}


function errorMessage(message) {

    document.getElementById("output").innerHTML = `
        <div class="error">
            ❌ Error: ${message}
        </div>
    `;
}


async function getData(url) {

    try {

        const response = await fetch(url);

        if (!response.ok) {

            throw new Error(
                "HTTP Error: " + response.status
            );
        }

        return await response.json();

    } catch (error) {

        errorMessage(error.message);

        return null;
    }
}


// ==========================================
// TRIGGER SUMMARY
// ==========================================

async function getSummary() {

    try {

        const response =
            await fetch(API + "/summary");

        if (!response.ok) {

            throw new Error(
                "Unable to load summary"
            );
        }

        const data =
            await response.json();


        document.getElementById("totalRentals")
            .innerText =
            data.totalRentals;


        document.getElementById("totalPayment")
            .innerText =
            "₹" + data.totalPayment;


    } catch (error) {

        document.getElementById("totalRentals")
            .innerText = "Error";

        document.getElementById("totalPayment")
            .innerText = "Error";

        console.log(error);
    }
}


// Load summary automatically
window.onload = function () {

    getSummary();

};


// ==========================================
// ALL VEHICLES
// ==========================================

async function getAllVehicles() {

    loading();

    document.getElementById("resultTitle")
        .innerText =
        "All Vehicles";


    const data =
        await getData(
            API + "/vehicles"
        );


    if (data) {

        displayVehicles(data);

    }
}


// ==========================================
// VEHICLES + BRANCH
// ==========================================

async function getVehiclesWithBranch() {

    loading();

    document.getElementById("resultTitle")
        .innerText =
        "Vehicles + Branch";


    const data =
        await getData(
            API + "/vehicles/with-branch"
        );


    if (data) {

        displayVehicleBranch(data);

    }
}


// ==========================================
// ABOVE AVERAGE
// ==========================================

async function getAboveAverage() {

    loading();

    document.getElementById("resultTitle")
        .innerText =
        "Vehicles Above Average Rent";


    const data =
        await getData(
            API + "/vehicles/above-average-rent"
        );


    if (data) {

        displayVehicles(data);

    }
}


// ==========================================
// MOST EXPENSIVE
// ==========================================

async function getMostExpensive() {

    loading();

    document.getElementById("resultTitle")
        .innerText =
        "Most Expensive Vehicle";


    const data =
        await getData(
            API + "/vehicles/most-expensive"
        );


    if (data) {

        displayVehicles(data);

    }
}


// ==========================================
// ANY
// ==========================================

async function getGreaterThanAnyBike() {

    loading();

    document.getElementById("resultTitle")
        .innerText =
        "Greater Than ANY Bike";


    const data =
        await getData(
            API + "/vehicles/greater-than-any-bike"
        );


    if (data) {

        displayVehicles(data);

    }
}


// ==========================================
// ALL
// ==========================================

async function getGreaterThanAllBikes() {

    loading();

    document.getElementById("resultTitle")
        .innerText =
        "Greater Than ALL Bikes";


    const data =
        await getData(
            API + "/vehicles/greater-than-all-bikes"
        );


    if (data) {

        displayVehicles(data);

    }
}


// ==========================================
// DISPLAY VEHICLES
// ==========================================

function displayVehicles(data) {

    if (data.length === 0) {

        document.getElementById("output").innerHTML =
            `<div class="empty">
                No vehicles found.
            </div>`;

        return;
    }


    let html = `

        <div class="table-container">

        <table>

        <thead>

            <tr>

                <th>Vehicle ID</th>

                <th>Vehicle Number</th>

                <th>Type</th>

                <th>Rent / Day</th>

                <th>Branch ID</th>

            </tr>

        </thead>

        <tbody>
    `;


    data.forEach(vehicle => {

        html += `

            <tr>

                <td>
                    ${vehicle.vehicleId}
                </td>

                <td>
                    ${vehicle.vehicleNumber}
                </td>

                <td>
                    ${vehicle.vehicleType}
                </td>

                <td>
                    ₹${vehicle.rentPerDay}
                </td>

                <td>
                    ${vehicle.branchId}
                </td>

            </tr>

        `;

    });


    html += `
        </tbody>
        </table>
        </div>
    `;


    document.getElementById("output")
        .innerHTML = html;
}


// ==========================================
// VEHICLE + BRANCH
// ==========================================

function displayVehicleBranch(data) {

    if (data.length === 0) {

        document.getElementById("output").innerHTML =
            `<div class="empty">
                No data found.
            </div>`;

        return;
    }


    let html = `

        <div class="table-container">

        <table>

        <thead>

            <tr>

                <th>Vehicle ID</th>

                <th>Vehicle Number</th>

                <th>Type</th>

                <th>Rent / Day</th>

                <th>Branch</th>

                <th>City</th>

            </tr>

        </thead>

        <tbody>
    `;


    data.forEach(row => {

        html += `

            <tr>

                <td>${row[0]}</td>

                <td>${row[1]}</td>

                <td>${row[2]}</td>

                <td>₹${row[3]}</td>

                <td>${row[4]}</td>

                <td>${row[5]}</td>

            </tr>

        `;

    });


    html += `
        </tbody>
        </table>
        </div>
    `;


    document.getElementById("output")
        .innerHTML = html;
}


// ==========================================
// CUSTOMERS
// ==========================================

async function getCustomers() {

    loading();

    document.getElementById("resultTitle")
        .innerText =
        "Customers";


    const data =
        await getData(
            API + "/customers"
        );


    if (!data) return;


    let html = `

        <div class="table-container">

        <table>

        <thead>

            <tr>

                <th>Customer ID</th>

                <th>Name</th>

                <th>Phone</th>

                <th>City</th>

            </tr>

        </thead>

        <tbody>
    `;


    data.forEach(customer => {

        html += `

            <tr>

                <td>${customer.customerId}</td>

                <td>${customer.customerName}</td>

                <td>${customer.phone}</td>

                <td>${customer.city}</td>

            </tr>

        `;

    });


    html += `
        </tbody>
        </table>
        </div>
    `;


    document.getElementById("output")
        .innerHTML = html;
}


// ==========================================
// RENTALS
// ==========================================

async function getRentals() {

    loading();

    document.getElementById("resultTitle")
        .innerText =
        "Rentals";


    const data =
        await getData(
            API + "/rentals"
        );


    if (!data) return;


    let html = `

        <div class="table-container">

        <table>

        <thead>

            <tr>

                <th>Rental ID</th>

                <th>Customer ID</th>

                <th>Vehicle ID</th>

                <th>Start Date</th>

                <th>Return Date</th>

            </tr>

        </thead>

        <tbody>
    `;


    data.forEach(rental => {

        html += `

            <tr>

                <td>${rental.rentalId}</td>

                <td>${rental.customerId}</td>

                <td>${rental.vehicleId}</td>

                <td>${rental.startDate}</td>

                <td>${rental.returnDate}</td>

            </tr>

        `;

    });


    html += `
        </tbody>
        </table>
        </div>
    `;


    document.getElementById("output")
        .innerHTML = html;
}


// ==========================================
// RENTAL DETAILS
// ==========================================

async function getRentalsWithDetails() {

    loading();

    document.getElementById("resultTitle")
        .innerText =
        "Rental Details";


    const data =
        await getData(
            API + "/rentals/with-customer-vehicle"
        );


    if (!data) return;


    let html = `

        <div class="table-container">

        <table>

        <thead>

            <tr>

                <th>Rental ID</th>

                <th>Customer</th>

                <th>Vehicle Number</th>

                <th>Vehicle Type</th>

                <th>Start Date</th>

                <th>Return Date</th>

            </tr>

        </thead>

        <tbody>
    `;


    data.forEach(row => {

        html += `

            <tr>

                <td>${row[0]}</td>

                <td>${row[1]}</td>

                <td>${row[2]}</td>

                <td>${row[3]}</td>

                <td>${row[4]}</td>

                <td>${row[5]}</td>

            </tr>

        `;

    });


    html += `
        </tbody>
        </table>
        </div>
    `;


    document.getElementById("output")
        .innerHTML = html;
}


// ==========================================
// PAYMENTS
// ==========================================

async function getPayments() {

    loading();

    document.getElementById("resultTitle")
        .innerText =
        "Payments";


    const data =
        await getData(
            API + "/payments"
        );


    if (!data) return;


    let html = `

        <div class="table-container">

        <table>

        <thead>

            <tr>

                <th>Payment ID</th>

                <th>Rental ID</th>

                <th>Amount</th>

                <th>Payment Date</th>

            </tr>

        </thead>

        <tbody>
    `;


    data.forEach(payment => {

        html += `

            <tr>

                <td>${payment.paymentId}</td>

                <td>${payment.rentalId}</td>

                <td>₹${payment.amount}</td>

                <td>${payment.paymentDate}</td>

            </tr>

        `;

    });


    html += `
        </tbody>
        </table>
        </div>
    `;


    document.getElementById("output")
        .innerHTML = html;
}


// ==========================================
// PAYMENT DETAILS
// ==========================================

async function getPaymentsWithRental() {

    loading();

    document.getElementById("resultTitle")
        .innerText =
        "Payment + Rental Details";


    const data =
        await getData(
            API + "/payments/with-rental"
        );


    if (!data) return;


    let html = `

        <div class="table-container">

        <table>

        <thead>

            <tr>

                <th>Payment ID</th>

                <th>Rental ID</th>

                <th>Amount</th>

                <th>Payment Date</th>

                <th>Customer ID</th>

                <th>Vehicle ID</th>

            </tr>

        </thead>

        <tbody>
    `;


    data.forEach(row => {

        html += `

            <tr>

                <td>${row[0]}</td>

                <td>${row[1]}</td>

                <td>₹${row[2]}</td>

                <td>${row[3]}</td>

                <td>${row[4]}</td>

                <td>${row[5]}</td>

            </tr>

        `;

    });


    html += `
        </tbody>
        </table>
        </div>
    `;


    document.getElementById("output")
        .innerHTML = html;
}


// ==========================================
// BRANCHES
// ==========================================

async function getBranches() {

    loading();

    document.getElementById("resultTitle")
        .innerText =
        "Branches";


    const data =
        await getData(
            API + "/branches"
        );


    if (!data) return;


    let html = `

        <div class="table-container">

        <table>

        <thead>

            <tr>

                <th>Branch ID</th>

                <th>Branch Name</th>

                <th>City</th>

            </tr>

        </thead>

        <tbody>
    `;


    data.forEach(branch => {

        html += `

            <tr>

                <td>${branch.branchId}</td>

                <td>${branch.branchName}</td>

                <td>${branch.city}</td>

            </tr>

        `;

    });


    html += `
        </tbody>
        </table>
        </div>
    `;


    document.getElementById("output")
        .innerHTML = html;
}


// ==========================================
// CLEAR
// ==========================================

function clearResults() {

    document.getElementById("resultTitle")
        .innerText = "Results";


    document.getElementById("output").innerHTML = `

        <div class="empty">

            <div>🚘</div>

            <h3>Ready to explore?</h3>

            <p>
                Select any query above.
            </p>

        </div>

    `;
}