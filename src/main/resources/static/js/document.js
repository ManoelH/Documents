$('#modal-delete').on('show.bs.modal', function (event) {
  var button = $(event.relatedTarget)
  var id = button.data('id')
  var description = button.data('description');
  
  var modal = $(this)
  var form = modal.find('form')
  var action = form.attr('action')
  if(!action.endsWith('/'))
	  action+='/'
  if(action =='/documents/')
	  form.attr('action', action+id)
  modal.find('.modal-body span').html('Do you really want to delete <strong>'+description+'</strong>?')
  		  
})