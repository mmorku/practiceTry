const API_BASE_URL = "http://localhost:8082";

export async function getUsers() {
  const response = await fetch(`${API_BASE_URL}/user`);
  const users = await response.json();
  return users;
}

export const getUsersByID = async (userId) => {
  const response = await fetch(`${API_BASE_URL}/user/${userId}`);
  const user = await response.json();
  return user;
};

export const saveUser = async (user) => {
  await fetch(`${API_BASE_URL}/user`, {
    method: "POST",
    headers: {
      "Content-Type": "application/json",
    },
    body: JSON.stringify(user),
  });

  alert("User saved successfully!");
};

export const putUser = async (user, id) => {
  await fetch(`${API_BASE_URL}/user/${id}`, {
    method: "PUT",
    headers: {
      "Content-Type": "application/json",
    },
    body: JSON.stringify(user),
  });

  alert(`[User ${id}] replaced successfully!`);
};

export const patchUser = async (user, id) => {
  await fetch(`${API_BASE_URL}/user/${id}`, {
    method: "PATCH",
    headers: {
      "Content-Type": "application/json",
    },
    body: JSON.stringify(user),
  });

  alert(`[User ${id}] updated successfully!`);
};

export const deleteUserById = async (userId) => {
  await fetch(`${API_BASE_URL}/user/${userId}`, {
    method: "DELETE",
  });

  alert(`[User ${userId}] deleted successfully`);
};
