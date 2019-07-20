package pl.bykowski.restclient;

import com.vaadin.flow.component.Html;
import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Arrays;

@Route("jobs")
public class JobGui extends VerticalLayout {

    private JobClient jobClient;

    @Autowired
    public JobGui(JobClient jobClient) {
        this.jobClient = jobClient;

        Arrays.stream(jobClient.getDataFromGitHubApi()).forEach(element -> {
            HorizontalLayout horizontalLayout = new HorizontalLayout();
            Label labelCompany = new Label(element.getCompany());
            Image image = new Image(element.getCompanyLogo(), "logo");
            horizontalLayout.add(labelCompany);
            horizontalLayout.add(image);
            image.setHeight("100px");

            Label label = new Label();
            label.getElement().setProperty("innerHTML", element.getDescription());
            add(horizontalLayout, label);
            add("-----------");
        });


    }



}
