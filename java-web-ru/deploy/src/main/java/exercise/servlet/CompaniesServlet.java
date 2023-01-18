package exercise.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.util.ArrayList;
import java.util.List;
import static exercise.Data.getCompanies;

public class CompaniesServlet extends HttpServlet {

    @Override
    public void doGet(HttpServletRequest request,
                      HttpServletResponse response)
                throws IOException, ServletException {

        // BEGIN
        PrintWriter pw = response.getWriter();

        List<String> companyList = getCompanies();
        List<String> validCompanies = new ArrayList<>();

        if (request.getQueryString() == null) {
            for (String company : companyList) {
                pw.println(company);
            }
        } else {
            if (request.getParameter("search") == null || request.getParameter("search").equals("")) {
                for (String company : companyList) {
                    pw.println(company);
                }
            } else {
                for (String company : companyList) {
                    if (company.contains(request.getParameter("search"))) {
                        validCompanies.add(company);
                    }
                }
                if (validCompanies.size() == 0) {
                    pw.println("Companies not found");
                } else {
                    for (String vCompany : validCompanies) {
                        pw.println(vCompany);
                    }
                }
            }
        }
        // END
    }
}
