document.getElementById("bloodRequestForm").addEventListener("submit", function(event) {
    event.preventDefault(); // Prevent form submission

    let isValid = true;
    let errors = document.querySelectorAll(".error-message");
    errors.forEach(error => error.innerText = ""); // Clear previous errors

    function showError(id, message) {
        document.querySelector(#${id}.error-message).innerText = message;
        isValid = false;
    }

    // Get form values
    let fullName = document.getElementById("fullName").value.trim();
    let bloodType = document.getElementById("bloodType").value;
    let urgency = document.getElementById("urgency").value;
    let hospital = document.getElementById("hospital").value.trim();
    let city = document.getElementById("city").value.trim();
    let pinCode = document.getElementById("pinCode").value.trim();
    let contactMethod = document.querySelector('input[name="contactMethod"]:checked');

    // Validations
    if (fullName.length < 3) showError("fullName", "Enter a valid full name.");
    if (!bloodType) showError("bloodType", "Please select a blood type.");
    if (!urgency) showError("urgency", "Please select urgency level.");
    if (hospital.length < 3) showError("hospital", "Enter a valid hospital name.");
    if (city.length < 2) showError("city", "Enter a valid city.");
    if (!/^\d{6}$/.test(pinCode)) showError("pinCode", "Enter a valid 6-digit PIN code.");
    if (!contactMethod) showError("contactEmail", "Select a contact method.");

    if (isValid) {
        alert("Blood request submitted successfully!");
        document.getElementById("bloodRequestForm").reset();
    }
});