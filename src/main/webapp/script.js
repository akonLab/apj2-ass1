function btn(name) {
    if (name === task2) {
        document.getElementById('task1').style.display = 'none';
        document.getElementById('task2').style.display = 'block';

    } else {
        document.getElementById('task1').style.display = 'block';
        document.getElementById('task2').style.display = 'none';

    }
}