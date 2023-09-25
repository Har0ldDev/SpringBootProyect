// Call the dataTables jQuery plugin
$(document).ready(function() {
    //on ready
});

async function registerUsers(){

    let data = {};
    data.name = document.getElementById('txtFirstName').value;
    data.lastname = document.getElementById('txtLastName').value;
    data.email = document.getElementById('txtEmail').value;
    data.password = document.getElementById('txtPassword').value;

    let repeatPassword = document.getElementById('txtRepeatPassword').value;

    if (repeatPassword != data.password) {
        alert('La contraseñas no coinciden.');
        return;
    }


    const request = await fetch('api/users', {
    method: 'POST',
    headers: {
        'Accept' : 'application/json',
        'Content-Type': 'application/json'
    },
    body: JSON.stringify(data)
    });
    alert("La cuenta fue creada con éxito!");
    window.location.href='login.html';
}