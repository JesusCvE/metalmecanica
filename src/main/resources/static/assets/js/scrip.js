$(document).ready(function() {
    $('.table .delBtn').on('click', function(event) {
        event.preventDefault();

        var href = $(this).attr('href');

        $('#myModal #delRef').attr('href', href);
        // $('#myModal').modal();
        $('#myModalCart').modal();
    });
});

(function (document) {
    'use strict';

    var LightTableFilter = (function (Arr) {

        var _input;

        function _onInputEvent(e) {
            _input = e.target;
            var tables = document.getElementsByClassName(_input.getAttribute('data-table'));
            Arr.forEach.call(tables, function (table) {
                Arr.forEach.call(table.tBodies, function (tbody) {
                    Arr.forEach.call(tbody.rows, _filter);
                });
            });
        }

        function _filter(row) {
            var text = row.textContent.toLowerCase(), val = _input.value.toLowerCase();
            row.style.display = text.indexOf(val) === -1 ? 'none' : 'table-row';
        }

        return {
            init: function () {
                var inputs = document.getElementsByClassName('light-table-filter');
                Arr.forEach.call(inputs, function (input) {
                    input.oninput = _onInputEvent;
                });
            }
        };
    })(Array.prototype);

    document.addEventListener('readystatechange', function () {
        if (document.readyState === 'complete') {
            LightTableFilter.init();
        }
    });

})(document);



const $btnExportar = document.querySelector(".btnExportar"),
$tabla = document.querySelector(".tabla");

$btnExportar.addEventListener("click", function () {
    let tableExport = new TableExport($tabla, {
        exportButtons: false, // No queremos botones
        filename: "Reporte de Tabla", //Nombre del archivo de Excel
        sheetname: "Reporte", //Título de la hoja
    });
    let datos = tableExport.getExportData();
    console.log(datos);
    let preferenciasDocumento = datos.tabla.xlsx;
    tableExport.export2file(
        preferenciasDocumento.data,
        preferenciasDocumento.mimeType,
        preferenciasDocumento.filename,
        preferenciasDocumento.fileExtension,
        preferenciasDocumento.merges,
        preferenciasDocumento.RTL,
        preferenciasDocumento.sheetname
    );
});


let boton = document.getElementById('calcular');
let total = document.getElementById('demo');

boton.addEventListener('click',hacerSuma);

function hacerSuma(){
    let n1=parseFloat(document.getElementById('precio').value);
    let n2=parseFloat(document.getElementById('cantidad').value);

    let s=n1*n2;
    total.innerHTML=`La suma es ${s}`;
}