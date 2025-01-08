function chamaNiveis(limpar) {
    nivel = $("#nivel").val();

    $.ajax({
        url: "../Turmas/lista",
        data: "nivel=" + nivel,
        dataType: "json",
        success: function (t) {


            if (limpar) {
                $("#turmas").html("")
            }

            for (var i = 0; i < t.length; i++) {
                opt = "<option value=" + t[i].id + ">" + t[i].nome + "</option>"

                $("#turmas").append(opt);


            }


        }
    });
}


$(function () {

    $("#nivel").change(function () {

        chamaNiveis(true)


    });

    if ($("#idNivel").val() != "") {
        chamaNiveis(false)
    }


})


