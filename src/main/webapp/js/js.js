var d = document;
var cam = 'govno';
var ping;


$(document).ready(function () {
    $("#ping").click(function () {
        $.ajax({
            url:"/ping",
            type:"GET",
            contentType:"application/json; charset=utf-8",
            dataType:"text",
            success: function(result){
                ping = result;
                console.log(result);
                alert(result);
                    // Находим нужную таблицу
    var tbody = d.getElementById('tab1').getElementsByTagName('TBODY')[0];

    // Создаем строку таблицы и добавляем ее
    var row = d.createElement("TR");
    tbody.appendChild(row);

    // Создаем ячейки в вышесозданной строке
    // и добавляем тх
    var td1 = d.createElement("TD");
    var td2 = d.createElement("TD");

    row.appendChild(td1);
    row.appendChild(td2);

    // Наполняем ячейки
    td1.innerHTML = cam;
    td2.innerHTML = ping;
            }
        });
    });
    });
    