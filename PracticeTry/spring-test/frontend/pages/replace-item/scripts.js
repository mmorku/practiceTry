import { getItemByID, putItem } from "../../commons/requests.js";

const replaceItemForm = document
  .getElementById("replaceItemForm")
  .querySelector("form");

let oldItemData;

const loadItemData = async () => {
  const urlParams = new URLSearchParams(window.location.search);
  const itemId = urlParams.get("id");

  oldItemData = await getItemByID(itemId);
  editItemForm.itemName.value = oldItemData.name;
  editItemForm.itemManufacturer.value = oldItemData.manufacturer;
  editItemForm.itemModel.value = oldItemData.model;
  editItemForm.itemManufactureDate.value = oldItemData.manufactureDate;
  editItemForm.itemWeight.value = oldItemData.weight;
  editItemForm.itemPrice.value = oldItemData.price;
  editItemForm.itemAvailability.value = oldItemData.availability;
};

const handleFormSubmit = async () => {
  replaceUserForm.addEventListener("submit", async (e) => {
    e.preventDefault();

    const item = {
      name:
        oldItemData.name !== editItemForm.itemName.value
          ? editItemForm.itemName.value
          : undefined,
      manufacturer:
        oldItemData.manufacturer !== editItemForm.itemManufacturer.value
          ? editItemForm.itemManufacturer.value
          : undefined,
      model:
        oldItemData.model !== editItemForm.itemModel.value
          ? editItemForm.itemModel.value
          : undefined,
      manufactureDate:
        oldItemData.manufactureDate !== editItemForm.itemManufactureDate.value
          ? editItemForm.itemManufactureDate.value
          : undefined,
      weight:
        oldItemData.weight !== editItemForm.itemWeight.value
          ? editItemForm.itemWeight.value
          : undefined,
      price:
        oldItemData.price !== editItemForm.itemPrice.value
          ? editItemForm.itemPrice.value
          : undefined,
      availability:
        oldItemData.availability !== editItemForm.itemAvailability.value
          ? editItemForm.itemAvailability.value
          : undefined,
    };

    await putItem(item, oldItemData.id);
    window.location.replace("../item-list/item-list.html");
  });
};

const handleCancelButton = () => {
  document.getElementById("cancelButton").addEventListener("click", () => {
    window.location.replace("../item-list/item-list.html");
  });
};

(async () => {
  await loadItemData();
  handleCancelButton();
  await handleFormSubmit();
})();
