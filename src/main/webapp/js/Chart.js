google.charts.load('current', {'packages':['corechart']});
google.charts.setOnLoadCallback(drawChart);

function drawChart() {
  var data = google.visualization.arrayToDataTable([
    ['Время', 'Пинг'],
    ['20:12',  63,],
    ['20:13',  70],
    ['20:14',  56],
    ['20:15',  44]
  ]);

  var options = {
    title: 'Пинг камеры',
    hAxis: {title: 'Камера №1',  titleTextStyle: {color: '#333'}},
    vAxis: {minValue: 0}
  };

  var chart = new google.visualization.AreaChart(document.getElementById('chart_div'));
  chart.draw(data, options);
}