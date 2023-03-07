import { deleteItemById, getItems } from "../../commons/requests.js";

const renderItemTableRows = async (items) => {
  const itemTable = document.getElementById("itemTable");
  const itemTableBody = itemTable.querySelector("tbody");
  console.log(items);
  item.forEach((i) => {
    const itemRow = document.createElement("tr");

    const nameCell = document.createElement("td");
    nameCell.innerText = i.name;
    itemRow.appendChild(nameCell);

    const manufacturerCell = document.createElement("td");
    manufacturerCell.innerText = i.manufacturer;
    itemRow.appendChild(manufacturerCell);

    const modelCell = document.createElement("td");
    modelCell.innerText = i.model;
    itemRow.appendChild(modelCell);

    const manufactureDateCell = document.createElement("td");
    manufactureDateCell.innerText = i.manufacturerDate;
    itemRow.appendChild(manufactureDateCell);

    const weightCell = document.createElement("td");
    weightCell.innerText = i.weight;
    itemRow.appendChild(weightCell);

    const priceCell = document.createElement("td");
    priceCell.innerText = i.price;
    itemRow.appendChild(priceCell);

    const availabilityCell = document.createElement("td");
    availabilityCell.innerText = i.availability;
    itemRow.appendChild(availabilityCell);

    const actionCell = document.createElement("td");

    const editButton = document.createElement("button");
    editButton.innerText = "EDIT";
    editButton.className = "btn btn-warning";
    editButton.style = "margin-right: 10px";
    editButton.addEventListener("click", async () => {
      window.location.replace(`../edit-item/edit-item.html?id=${i.id}`);
    });
    actionCell.appendChild(editButton);

    const replaceButton = document.createElement("button");
    replaceButton.innerText = "REPLACE";
    replaceButton.className = "btn btn-warning";
    replaceButton.style = "margin-right: 10px";
    replaceButton.addEventListener("click", async () => {
      window.location.replace(`../replace-item/replace-item.html?id=${i.id}`);
    });
    actionCell.appendChild(replaceButton);

    const deleteButton = document.createElement("button");
    deleteButton.innerText = "DELETE";
    deleteButton.className = "btn btn-danger";
    deleteButton.addEventListener("click", async () => {
      await deleteItemById(i.id);
      window.location.reload();
    });
    actionCell.appendChild(deleteButton);

    itemRow.appendChild(actionCell);

    itemTableBody.appendChild(itemRow);
  });
};

const handleAddNewItemButton = () => {
  document.getElementById("addItem").addEventListener("click", () => {
    window.location.replace("../add-item/add-item.html");
  });
};

(async () => {
  handleAddNewItemButton();
  const item = await getItems();
  renderItemTableRows(item);
})();
