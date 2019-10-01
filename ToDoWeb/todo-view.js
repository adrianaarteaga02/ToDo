var data = [];
var selectedEntry = null;

resetForm();

// fetch all entries and show them in the table
getAllEntries().then(entries => {
    data = entries;
    renderData();
});

function onFormSubmit() {
    var checkIn = document.getElementById("checkIn").value;
    var checkOut = document.getElementById("checkOut").value;

    if (!checkIn || !checkOut) {
        // data is invalid
        return;
    }

    var entry = { checkIn: checkIn, checkOut: checkOut };
    if (selectedEntry == null) {
        createEntry(entry).then(createdEntry => {
            data.push(createdEntry);
            renderData();
            resetForm();
        });
    } else {
        updateEntry(selectedEntry.id, entry).then(updatedEntry => {
            selectedEntry.checkIn = updatedEntry.checkIn;
            selectedEntry.checkOut = updatedEntry.checkOut;
            renderData();
            resetForm();
        });
    }
}

function resetForm() {
    var oldDate = new Date();
    oldDate.setMinutes(oldDate.getMinutes() - 10);
    document.getElementById("checkIn").value = oldDate.toISOString().substring(0, 16);
    document.getElementById("checkOut").value = new Date().toISOString().substring(0, 16);
    selectedEntry = null;
}

function onEdit(index) {
    selectedEntry = data[index];
    document.getElementById("checkIn").value = selectedEntry.checkIn;
    document.getElementById("checkOut").value = selectedEntry.checkOut;
}

function onDelete(index) {
    if (confirm('Are you sure to delete this record ?')) {
        selectedEntry = data[index];
        deleteEntry(selectedEntry.id);
        data.splice(index, 1);
        renderData();
        resetForm();
    }
}

function renderData() {
    var table = document.getElementById("entryList").getElementsByTagName('tbody')[0];

    // delete existing rows
    for(var i = table.rows.length - 1; i >= 0; i--)
    {
        table.deleteRow(i);
    }

    // add all rows from the data array
    for (var i = 0; i < data.length; i++) {
        var entry = data[i];
        var newRow = table.insertRow(table.length);
        cell1 = newRow.insertCell(0);
        cell1.innerHTML = entry.id;
        cell1 = newRow.insertCell(1);
        cell1.innerHTML = entry.checkIn;
        cell1 = newRow.insertCell(2);
        cell1.innerHTML = entry.checkOut;
        cell2 = newRow.insertCell(3);
        cell2.innerHTML = `<a onClick="onEdit(${i})">Edit</a>
						   <a onClick="onDelete(${i})">Delete</a>`;
    }
}