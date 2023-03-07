import { saveItem } from "../../commons/requests.js";

const handleFormSubmit = async () => {
  const form = document.getElementById("addItemForm").querySelector("form");
  form.addEventListener("submit", async (e) => {
    e.preventDefault();
    const item = {
      name: form.itemName.value,
      manufacturer: form.itemManufacturer.value,
      model: form.itemModel.value,
      manufactureDate: form.itemManufactureDate.value,
      weight: form.itemWeight.value,
      price: form.itemPrice.value,
      availability: form.itemAvailability.value,
    };
    await saveItem(item);
    window.location.reload();
  });
};

const handleCancelButton = () => {
  document.getElementById("cancelButton").addEventListener("click", () => {
    window.location.replace("../item-list/item-list.html");
  });
};

(async () => {
  handleCancelButton();
  await handleFormSubmit();
})();
