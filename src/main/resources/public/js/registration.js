/**
 * Created by Parviz on 29.04.2018.
 */
// Variable to hold request
var request;
function getFormData($form){
    var unindexed_array = $form.serializeArray();
    var indexed_array = {};

    $.map(unindexed_array, function(n, i){
        indexed_array[n['name']] = n['value'];
    });

    return indexed_array;
}

// Bind to the submit event of our form
$("#regForm").submit(function(event){

    // Prevent default posting of form - put here to work in case of errors
    event.preventDefault();

    // Abort any pending request
    if (request) {
        request.abort();
    }
    // setup some local variables
    var $form = $(this);

    // Let's select and cache all the fields
    var $inputs = $form.find("input, select, button, textarea");

    // Serialize the data in the form
    // var serializedData = $("#regForm").serializeToString();
    // var data = JSON.stringify( $("#regForm").serializeArray() ); //  <-----------
    var $formData = $("#regForm");
    var data = JSON.stringify(getFormData($formData));

    console.log(data);
    // Let's disable the inputs for the duration of the Ajax request.
    // Note: we disable elements AFTER the form data has been serialized.
    // Disabled form elements will not be serialized.
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

    // Callback handler that will be called on success
    request.done(function (response, textStatus, jqXHR){
        // Log a message to the console
        $('#response').addClass('alert alert-success').html(response.message);
        $('#regForm').trigger("reset");
        $('#regForm').hide()
        $('#panelMsg').empty();
        $('#panelMsg').text("Your Entered Data");
        $('#responseData').show();
        $('#responseData ul').append('<li>Name : '+response.name+'</li>');
        $('#responseData ul').append('<li>Email :' +response.email+'</li>');
        if (response.phoneNumber!="") {
            $('#responseData ul').append('<li>Phone Number : ' + response.phoneNumber + '</li>');
        }
        $('#responseData ul').append('<li>Address : '+response.country+'</li>');
        console.log(response);
    });

    // Callback handler that will be called on failure
    request.fail(function (jqXHR, textStatus, errorThrown){
        // Log the error to the console
        if(jqXHR.status == 400){
            $('#response').addClass('alert alert-danger');
            $('#response').empty();
            alert(jqXHR.responseText);
            var data = JSON.parse(jqXHR.responseText);
            $.each(data, function (index, row) {
                $('#response').append('<h6>'+row.field + ' '+row.message+'</h6>');
                alert(row.field+ '=' + row.message);
            });

        }else
        {
            $('#response').addClass('alert alert-danger').html(jqXHR.responseText);
        }
    });

    // Callback handler that will be called regardless
    // if the request failed or succeeded
    request.always(function () {
        // Reenable the inputs
        $inputs.prop("disabled", false);
    });

});
