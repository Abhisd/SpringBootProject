<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<%@ include file="commonFields/header.jspf"%>
<%@ include file="commonFields/navigation.jspf"%>

<div class="container">

	<table class="table">
		<caption>Your Tasks</caption>
		<thead>
			<tr>
				<th>Description</th>
				<th>Target Date</th>
				<th>Is it Done?</th>
				<th></th>
				<th></th>

			</tr>
		</thead>
		<tbody>
			<c:forEach items="${todos}" var="todo">
				<tr>
					<td>${todo.desc}</td>
					<td><fmt:formatDate value="${todo.targetDate}"
							pattern="dd/MM/yyyy" /></td>
					<td>${todo.done}</td>
					<td><a type="button" class="btn btn-info"
						href="/update-todo?id=${todo.id}">Update</a></td>
					<td><a type="button" class="btn btn-warning"
						href="/delete-todo?id=${todo.id}">Delete</a></td>

				</tr>
			</c:forEach>


		</tbody>

	</table>
	<div>
		<h4>
			<a class="button" href="/add-todo"> Add Tasks here</a>
		</h4>
	</div>

</div>



<%@ include file="commonFields/footer.jspf"%>







