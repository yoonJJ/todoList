function addTodo() {
    const input = document.querySelector('input[name="content"]');
    const content = input.value.trim();
    if (!content) {
        alert("내용을 입력하세요!");
        return;
    }

    fetch('/api/todos', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify({ content: content, completed: false })
    }).then(res => {
        if (res.ok) location.reload();
        else alert("추가 실패");
    });
}

function toggleCompleted(id, checked) {
    fetch(`/api/todos/${id}`, {
        method: 'PUT',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify({ completed: checked })
    }).then(res => {
        if (!res.ok) alert("업데이트 실패");
        else location.reload();
    });
}

function deleteTodo(id) {
    fetch(`/api/todos/${id}`, {
        method: 'DELETE',
    }).then(response => {
        if (response.ok) {
            location.reload();
        } else {
            alert("삭제 실패");
        }
    });
}