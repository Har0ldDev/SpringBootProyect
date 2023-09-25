// Call the dataTables jQuery plugin
$(document).ready(function() {

    loadUsers();
  $('#users').DataTable();
});

async function loadUsers(){

    const request = await fetch('api/users', {
    method: 'GET',
    headers: {
        'Accept' : 'application/json',
        'Content-Type': 'application/json'
    }
    });
    const users = await request.json();

    let listHTML = '';
    for (let user of users){
        let btndelete = '<a href="#" onclick="deleteUser(' + user.id +')" class="btn btn-danger btn-circle"><i class="fas fa-trash"></i></a>';

        let textphone = user.phone == null ? '-' : usuario.telefono;

        let userHtml = '<tr><td>' + user.id + '</td><td>' + user.name + ' ' + user.lastname + '</td><td>' +
         user.email + '</td> <td>'+ textphone
        + '</td><td>'+ btndelete + '</td></tr>';
        listHTML += userHtml;
    }

    console.log(users);


document.querySelector('#users tbody').outerHTML = listHTML;
}

async function deleteUser(id){
    if (!confirm('Desea eliminar este Usuario?')){
        return;
    }

    const request = await fetch('api/users/'+id, {
        method: 'DELETE',
        headers: {
            'Accept' : 'application/json',
            'Content-Type': 'application/json'
        }
        });

    location.reload();
}