package ru.netology;

import org.apache.http.NameValuePair;
import org.apache.http.client.utils.URIBuilder;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

public class Request {
    private final String method;
    private final String path;
    private final List<NameValuePair> queryParams;

    public Request(String method, String path) throws URISyntaxException {
        this.method = method;
        this.path = path;
        this.queryParams = parseQueryParams();
    }

    public String getMethod() {
        return method;
    }

    public String getPath() {
        return path;
    }

    public String getQueryParam(String name) {
        return queryParams.stream()
                .filter(x -> x.getName().equals(name))
                .findFirst()
                .map(NameValuePair::getValue)
                .orElse(null);
    }

    public List<NameValuePair> getQueryParams() {
        return queryParams;
    }

    private List<NameValuePair> parseQueryParams() throws URISyntaxException {
        URIBuilder uriBuilder = new URIBuilder(new URI(path));
        return uriBuilder.getQueryParams();
    }


}