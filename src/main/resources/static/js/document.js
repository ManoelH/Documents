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

$(function() {
	$('.js-update-status').on('click', function (event) {
		event.preventDefault()
		var buttonToReceive = $(event.currentTarget)
		var urlReceive = buttonToReceive.attr('href')
		
		var response = $.ajax({
			url: urlReceive,
			type: "PUT"
		});
		
		response.done(function(e) {
			var idDocument = buttonToReceive.data("id")
			$('[data-role=' + idDocument + ']').html('<span class="label">'+ e +'</span>')
			buttonToReceive.hide()
		})
		
		response.fail(function(e) {
			console.log(e)
			alert("One error happended")
		})
	})
})



		

