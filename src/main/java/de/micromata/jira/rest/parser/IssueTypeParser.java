package de.micromata.jira.rest.parser;

import com.google.gson.JsonObject;
import de.micromata.jira.rest.domain.IssueTypeBean;
import de.micromata.jira.rest.util.URIParser;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Christian
 * Date: 07.03.13
 * Time: 15:26
 * To change this template use File | Settings | File Templates.
 */
public class IssueTypeParser extends BaseParser {

    public static IssueTypeBean parse(JsonObject object) {
        IssueTypeBean bean = new IssueTypeBean();
        parseBaseProperties(bean, object);
        String description = object.get(PROP_DESCRIPTION).getAsString();
        boolean subtask = object.get(PROP_SUBTASK).getAsBoolean();
        String iconURL = object.get(PROP_ICONURL).getAsString();
        URI uriIcon = URIParser.parseStringToURI(iconURL);
        bean.setDescription(description);
        bean.setIconURL(uriIcon);
        bean.setSubtask(subtask);
        return bean;
    }

    public static List<IssueTypeBean> parse(List<JsonObject> objects) {
        List<IssueTypeBean> retval = new ArrayList<IssueTypeBean>();
        for (JsonObject object : objects) {
            IssueTypeBean issueTypeBean = parse(object);
            retval.add(issueTypeBean);
        }
        return retval;
    }

}
