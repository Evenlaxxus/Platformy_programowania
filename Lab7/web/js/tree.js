$(function() {
    var data;
   

    $.ajax({url: "../data.json", success: function(result){
        data = JSON.parse(result);
        // console.log(data);
        $.map(data, function(node){
            node.text=node.label;
            delete node.label;

            node.children=node.nested;
            delete node.nested;

            $.map(node.children, function(bachor){
                bachor.text=bachor.label;
                delete bachor.label;
            });
        });
        // console.log(data);
    
        $('#tree').on('changed.jstree', function (e, data) {
            var descs = [];
            for(var i = 0, j = data.selected.length; i < j; i++) {
                descs.push(data.instance.get_node(data.selected[i]).text);
            }
            $('#description').html(descs.join(', '));
          }).jstree({
            'core': {
            'data': data
            },
            'types': {
            'file': {
            'icon': 'jstree-file'
            },
            'dir': {
            'icon': 'jstree-folder'
            }
            },
            'plugins': [ 'types' ]
            });
      }});

    // alert("Działam - JavaScript :)");

    // TODO

});
