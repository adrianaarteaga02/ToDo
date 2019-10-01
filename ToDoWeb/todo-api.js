var entriesUrl = "http://localhost:8081/todo";

async function getAllEntries() {
    var response = await fetch(entriesUrl);
    return await response.json();
}

async function createEntry(entry) {
    var response = await fetch(entriesUrl, {
        method: 'POST',
        body: JSON.stringify(entry),
        headers: {
            'Content-Type': 'application/json'
        }
    });
    return await response.json();
}

async function updateEntry(id, entry) {
    var response = await fetch(entriesUrl + "/" + id, {
        method: 'PUT',
        body: JSON.stringify(entry),
        headers: {
            'Content-Type': 'application/json'
        }
    });
    return await response.json();
}

async function deleteEntry(id) {
    await fetch(entriesUrl + "/" + id, {
        method: 'DELETE'
    });
}