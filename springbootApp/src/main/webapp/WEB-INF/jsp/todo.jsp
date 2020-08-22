<%@ include file="commonFields/header.jspf" %>
<%@ include file="commonFields/navigation.jspf" %>
<div class="container">
	<h4>Add Tasks here.</h4>



	<form:form method="post" commandName="todo">
		<form:hidden path="id"></form:hidden>
		<fieldset class="form-group">
			<form:label path="desc">Description</form:label>
			<form:input path="desc" type="text" class="form-control"
				required="required" />
			<form:errors path="desc" cssClass="text-warning"></form:errors>
		</fieldset>
		<fieldset class="form-group">
			<form:label path="targetDate">Target Date</form:label>
			<form:input path="targetDate" type="text" class="form-control"
				required="required" />
			<form:errors path="targetDate" cssClass="text-warning"></form:errors>
		</fieldset>
		<button type="submit" class="btn btn-success">ADD</button>

	</form:form>
</div>
<%@ include file="commonFields/footer.jspf" %>

