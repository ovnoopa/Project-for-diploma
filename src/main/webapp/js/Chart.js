google.charts.load('current', {'packages':['corechart']});
google.charts.setOnLoadCallback(drawChart);

function drawChart() {
  var data = google.visualization.arrayToDataTable([
    ['Время', 'Ping'],
    ['20:10',  169,],
    ['20:05',  151],
    ['20:00',  130],
    ['19:55',  176],
    ['19:50',  152],
    ['19:45',  147],
    ['19:40',  132],
    ['19:35',  121]
  ]);

  var options = {
    title: 'Ping устройства',
    hAxis: {title: 'Camera1',  titleTextStyle: {color: '#333'}},
    vAxis: {minValue: 0}
  };

  var chart = new google.visualization.AreaChart(document.getElementById('chart_div'));
  chart.draw(data, options);
}