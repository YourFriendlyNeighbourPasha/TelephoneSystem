function getView(id) {
    $(document).ready( function () {
            $.ajax({
                url: `/addresses/get/${id}`
            }).then(function (data) {
                console.log(JSON.stringify(data));
                $('.view-id').html(data.id);
                $('.view-district').html(data.district.name);
                $('.view-street').html(data.street);
                $('.view-building').html(data.building);
                $('.view-apartmentNo').html(data.apartmentNo);
                $('.view-zipCode').html(data.zipCode);
                var createdAt = new Date(data.created_at);
                $('.view-created-at').html(createdAt.toLocaleString('uk-UA'));
                var modifiedAt = new Date(data.modified_at);
                $('.view-modified-at').html(modifiedAt.toLocaleString('uk-UA'));
                var description = data.description === null ? '&mdash;' : data.description;
                $('.view-description').html(description);
            }).then(function () {
                $('#ModalView').modal('show');
            })
        }
    );
}

function getUpdate(id) {
    $(document).ready( function () {
            $.ajax({
                url: `/addresses/get/${id}`
            }).then(function (data) {
                $('#update-form').attr('action', `/addresses/update/${data.id}`)
                $( "input[name='update-id']" ).val(data.id);
                $( "select[name='update-district']" ).val(data.district.id);
                $( "input[name='update-street']" ).val(data.street);
                $( "input[name='update-building']" ).val(data.building);
                $( "input[name='update-apartment']" ).val(data.apartmentNo);
                $( "input[name='update-zipCode']" ).val(data.zipCode);
                $( "textarea[name='update-description']" ).val(data.description);
            }).then(function () {
                $('#ModalUpdateForm').modal('show');
            })
        }
    );
}

function getDelete(id) {
    $("#delete-province").attr('href', `/addresses/delete/${id}`);
    $("#ModalDelete").modal('show');
}


function sortTable(n, type) {
    var table, rows, switching, i, x, y, shouldSwitch, dir, switchcount = 0;
    table = document.getElementById("main-table");
    switching = true;
    dir = "asc";
    while (switching) {
        switching = false;
        rows = table.rows;
        for (i = 1; i < (rows.length - 1); i++) {

            shouldSwitch = false;

            x = rows[i].getElementsByTagName("TD")[n];
            y = rows[i + 1].getElementsByTagName("TD")[n];

            if(type === 'numeric') {
                if (dir === "asc") {
                    if (Number(x.innerHTML) > Number(y.innerHTML)) {
                        // If so, mark as a switch and break the loop:
                        shouldSwitch = true;
                        break;
                    }
                } else if (dir === "desc") {
                    if (Number(x.innerHTML) > Number(y.innerHTML)) {
                        // If so, mark as a switch and break the loop:
                        shouldSwitch = true;
                        break;
                    }
                }
            } else if(type === 'alphabetic') {
                if (dir === "asc") {
                    if (x.innerHTML.toLowerCase() > y.innerHTML.toLowerCase()) {
                        // If so, mark as a switch and break the loop:
                        shouldSwitch = true;
                        break;
                    }
                } else if (dir === "desc") {
                    if (x.innerHTML.toLowerCase() < y.innerHTML.toLowerCase()) {
                        // If so, mark as a switch and break the loop:
                        shouldSwitch = true;
                        break;
                    }
                }
            }
        }
        if (shouldSwitch) {

            rows[i].parentNode.insertBefore(rows[i + 1], rows[i]);
            switching = true;
            // Each time a switch is done, increase this count by 1:
            switchcount ++;
        } else {

            if (switchcount === 0 && dir === "asc") {
                dir = "desc";
                switching = true;
            }
        }
    }
}

$(".alert-close").click(function() {
    $(this)
        .parent(".alert")
        .fadeOut();
});