/**
 * Created by Parviz on 29.04.2018.
 */
var request;
function getFormData($form) {
    var unindexed_array = $form.serializeArray();
    var indexed_array = {};

    $.map(unindexed_array, function (n, i) {
        indexed_array[n['name']] = n['value'];
    });

    return indexed_array;
}
$("#regForm").submit(function (event) {
    event.preventDefault();

    if (request) {
        request.abort();
    }
    var $form = $(this);
    var $inputs = $form.find("input, select, button, textarea");
    var $formData = $("#regForm");
    var data = JSON.stringify(getFormData($formData));
    $inputs.prop("disabled", true);
    request = $.ajax({
        headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json'
        },
        url: "/register",
        type: "post",
        data: data,
        dataType: 'json'
    });
    request.done(function (response, textStatus, jqXHR) {
        $('#response').addClass('alert alert-success').html(response.message);
        $('#regForm').trigger("reset");
        $('#regForm').hide()
        $('#panelMsg').empty();
        $('#panelMsg').text("Your Entered Data");
        $('#responseData').show();
        $('#responseData ul').append('<li>Name : ' + response.name + '</li>');
        $('#responseData ul').append('<li>Email :' + response.email + '</li>');
        if (response.phoneNumber != "") {
            $('#responseData ul').append('<li>Phone Number : ' + response.phoneNumber + '</li>');
        }
        $('#responseData ul').append('<li>Address : ' + response.country + '</li>');
        console.log(response);
    });

    request.fail(function (jqXHR, textStatus, errorThrown) {
        if (jqXHR.status == 400) {
            $('#response').addClass('alert alert-danger');
            $('#response').empty();
            var data = JSON.parse(jqXHR.responseText);
            $.each(data, function (index, row) {
                $('#response').append('<h6><b>' + row.field + '</b> ' + row.message + '</h6>');
            });
        } else {
            $('#response').addClass('alert alert-danger').html(jqXHR.responseText);
        }
    });
    request.always(function () {
        $inputs.prop("disabled", false);
    });

});
