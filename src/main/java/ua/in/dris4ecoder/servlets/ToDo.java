package ua.in.dris4ecoder.servlets;

import ua.in.dris4ecoder.businessObjects.Task;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Alex Korneyko on 18.09.2016 16:14.
 */
public class ToDo extends HttpServlet {

    private List<Task> taskList = new ArrayList<>();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        if (request.getParameter("submit") != null) {
            if (!taskList.contains(new Task(request.getParameter("taskName")))) {
                taskList.add(new Task(request.getParameter("taskName"), request.getParameter("taskDescription")));
            }
        }

        if (request.getParameter("delete") != null) {
            taskList.remove(new Task(request.getParameter("delete")));
        }

        if (request.getParameter("update") != null) {
            taskList.forEach(task -> task.setComplete(false));
            if (request.getParameterValues("complete") != null) {
                Arrays.asList(request.getParameterValues("complete")).forEach(value -> taskList.get(taskList.indexOf(new Task(value))).setComplete(true));
            }
        }

        request.getSession().setAttribute("taskList", taskList);
        getServletContext().getRequestDispatcher("/todoList.jsp").forward(request, response);
    }
}
