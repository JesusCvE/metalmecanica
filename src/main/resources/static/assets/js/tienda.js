const addToShoppingCartButtons = document.querySelectorAll(".addToCart");
addToShoppingCartButtons.forEach((addToCartButton) => {
    addToCartButton.addEventListener("click", addToCartClicked);
});

const shoppingCartItemsContainer = document.querySelector('.shoppingCartItemsContainer');

function addToCartClicked(event) {
    const button = event.target;
    const item = button.closest('.itemm')
    console.log("🚀: addToCartClicked -> item:", item)

    const itemNombre = item.querySelector('.item-nombre').textContent;
    const itemPrecio = item.querySelector('.item-precio').textContent;
    const itemImg = item.querySelector('.item-img').src;
        
    addItemToShoppingCart(itemNombre, itemPrecio, itemImg);
}

function addItemToShoppingCart(itemNombre, itemPrecio, itemImg) {

    const elementsNombre = shoppingCartItemsContainer.getElementsByClassName('shoppingCartItemNombre')

    for (let i = 0; i < elementsNombre.length; i++) {
        if (elementsNombre[i].innerText === itemNombre) {
            let elementCantidad = elementsNombre[i].parentElement.parentElement.parentElement.querySelector('.shoppingCartItemCantidad');
            elementCantidad.value++;
            updateShoppingCartTotal();
            return;
        }
        
    }
    // console.log('🚀: addItemToShoppingCart -> elementsNombre:', elementsNombre);

    const shoppingCartRow = document.createElement('div');
    const shoppingCartContent = `
    <div class="row shoppingCartItem align-items-center">
        <div class="col-6">
            <div class="shopping-cart-item d-flex align-items-center ps-0 ms-0">
                <img src=${itemImg} class="shopping-cart-img w-20 mr-3 border-radius-lg" style="margin-right:10px">
                <h6 class="pl-5 ml-5 shopping-cart-nombre shoppingCartItemNombre text-truncate">${itemNombre}</h6>
            </div>
        </div>
        
        <div class="col-3">
            <div class="pt-2 shopping-cart-precio d-flex align-items-center">
                <input type="number" class="shoppingCartItemCantidad w-75 border-0" value="1">
                
            </div>
        </div>
        <div class="col-3">
            <div class="pt-2 shopping-cart-cantidad d-flex justify-content-between">
                <p class="item-precio mb-0 shoppingCartItemPrecio">${itemPrecio}</p>
                <button class="bg-transparent border-0 buttonDelete" type="button">
                    <svg xmlns="http://www.w3.org/2000/svg" width="20" height="20" fill="currentColor" class="bi bi-trash-fill text-danger" viewBox="0 0 16 16">
                        <path d="M2.5 1a1 1 0 0 0-1 1v1a1 1 0 0 0 1 1H3v9a2 2 0 0 0 2 2h6a2 2 0 0 0 2-2V4h.5a1 1 0 0 0 1-1V2a1 1 0 0 0-1-1H10a1 1 0 0 0-1-1H7a1 1 0 0 0-1 1H2.5zm3 4a.5.5 0 0 1 .5.5v7a.5.5 0 0 1-1 0v-7a.5.5 0 0 1 .5-.5zM8 5a.5.5 0 0 1 .5.5v7a.5.5 0 0 1-1 0v-7A.5.5 0 0 1 8 5zm3 .5v7a.5.5 0 0 1-1 0v-7a.5.5 0 0 1 1 0z"/>
                    </svg>
                </button>
            </div>
        </div>
    </div>`;

    shoppingCartRow.innerHTML = shoppingCartContent;
    shoppingCartItemsContainer.append(shoppingCartRow);

    shoppingCartRow.querySelector('.buttonDelete').addEventListener('click', removeShoppingCartItem);
    shoppingCartRow.querySelector('.shoppingCartItemCantidad').addEventListener('change', cantidadChange);

    updateShoppingCartTotal()
}

function updateShoppingCartTotal() {
    let total = 0;
    
    const shoppingCartTotal = document.querySelector('.shoppingCartTotal');
    const shoppingCartTotalInput = document.querySelector('.shoppingCartTotalInput');
    const shoppingCartItems = document.querySelectorAll('.shoppingCartItem');

    shoppingCartItems.forEach(shoppingCartItem => {
        const shoppingCartItemPrecioElement = shoppingCartItem.querySelector('.shoppingCartItemPrecio');
        const shoppingCartItemPrecio = Number(shoppingCartItemPrecioElement.textContent.replace('S/. ', ''));

        const shoppingCartItemCantidadElement = shoppingCartItem.querySelector('.shoppingCartItemCantidad')
        const shoppingCartItemCantidad = Number(shoppingCartItemCantidadElement.value)

        total = total + shoppingCartItemPrecio * shoppingCartItemCantidad

    });
    
    shoppingCartTotal.innerHTML = `S/. ${total.toFixed(2)}`
    shoppingCartTotalInput.value = `${total.toFixed(2)}`;
}

// Función para guardar los datos del modal en el almacenamiento local
function saveModalData() {
    // Obtener los elementos del modal
    var items = [];
    $(".shoppingCartItem").each(function () {
        var item = {
            img: $(this).find(".shopping-cart-img").attr("src"),
            nombre: $(this).find(".shoppingCartItemNombre").text(),
            precio: $(this).find(".shoppingCartItemPrecio").text(),
            cantidad: $(this).find(".shoppingCartItemCantidad").val(),
        };
        items.push(item);
    });

    // Guardar los datos en el almacenamiento local
    localStorage.setItem("modalData", JSON.stringify(items));
    updateShoppingCartTotal();
    removeShoppingCartItem();
}

// Función para cargar los datos del modal desde el almacenamiento local
function loadModalData() {
  // Obtener los datos del almacenamiento local
  var items = JSON.parse(localStorage.getItem('modalData'));
  
  // Rellenar el modal con los datos
  for (var i = 0; i < items.length; i++) {
    var item = items[i];
    // Agregar un elemento al modal con los datos de item

    const shoppingCartRow = document.createElement('div');
    const shoppingCartContent =  `
    <div class="row shoppingCartItem align-items-center">
        <div class="col-6">
            <div class="shopping-cart-item d-flex align-items-center ps-0 ms-0">
                <img src="${item.img}" class="shopping-cart-img w-20 mr-3 border-radius-lg" style="margin-right:10px">
                <h6 class="pl-5 ml-5 shopping-cart-nombre shoppingCartItemNombre text-truncate">${item.nombre}</h6>
            </div>
        </div>
        <div class="col-3">
            <div class="pt-2 shopping-cart-cantidad d-flex">
                <input type="number" class="shoppingCartItemCantidad w-75 border-0" value="${item.cantidad}">
            </div>
        </div>
        <div class="col-3">
            <div class="pt-2 shopping-cart-precio d-flex align-items-center justify-content-between">
                <p class="item-precio mb-0 shoppingCartItemPrecio">${item.precio}</p>
                <button class="bg-transparent border-0 buttonDelete" type="button">
                    <svg xmlns="http://www.w3.org/2000/svg" width="20" height="20" fill="currentColor" class="bi bi-trash-fill text-danger" viewBox="0 0 16 16">
                        <path d="M2.5 1a1 1 0 0 0-1 1v1a1 1 0 0 0 1 1H3v9a2 2 0 0 0 2 2h6a2 2 0 0 0 2-2V4h.5a1 1 0 0 0 1-1V2a1 1 0 0 0-1-1H10a1 1 0 0 0-1-1H7a1 1 0 0 0-1 1H2.5zm3 4a.5.5 0 0 1 .5.5v7a.5.5 0 0 1-1 0v-7a.5.5 0 0 1 .5-.5zM8 5a.5.5 0 0 1 .5.5v7a.5.5 0 0 1-1 0v-7A.5.5 0 0 1 8 5zm3 .5v7a.5.5 0 0 1-1 0v-7a.5.5 0 0 1 1 0z"/>
                    </svg>
                </button>
            </div>
        </div>
    </div>`;
    
    shoppingCartRow.innerHTML = shoppingCartContent;
    shoppingCartItemsContainer.append(shoppingCartRow);
  
    shoppingCartRow.querySelector('.buttonDelete').addEventListener('click', removeShoppingCartItem);
    shoppingCartRow.querySelector('.shoppingCartItemCantidad').addEventListener('change', cantidadChange);
    
    }

    updateShoppingCartTotal();
  
}

function removeShoppingCartItem(event) {
    const buttonClicked = event.target;
    buttonClicked.closest('.shoppingCartItem').remove();
    updateShoppingCartTotal();
}

function cantidadChange(event) {
    const input = event.target;
    
    if (input.value <= 0) {
        input.value = 1;
    }
    updateShoppingCartTotal();
}

// Guardar los datos del modal cuando el usuario envíe el formulario o cierre el modal
$('#myModalCart').on('hidden.bs.modal', function() {
    saveModalData();
  });

// Cargar los datos del modal cuando la página se cargue
$(document).ready(function() {
    loadModalData();
});