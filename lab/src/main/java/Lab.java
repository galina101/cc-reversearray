import java.net.URL;

public class Lab {
    /**
     * TODO: the method should return true if the provided String represents a valid url, and false if it doesn't.
     * Valid URLs will follow the pattern https://website.extension, potentially with path parameters such as
     * https://website.extension/path, and potentially with a query param such as
     * https://website.extension/path?var=abc, or multiple query params, such as
     * https://website.extension/path?var1=abc&var2=xyz
     *
     * A URL should always start with its protocol, https://
     * A URL must have any extension (such as .com)
     * The URL path should follow the extension, defined by a single slash /
     * The query parameters follow the path, defined by a question mark ?
     *
     * Tip: some string methods, such as split, will parse regex. "." and "?" are technically regex
     * statements, but you can break out of regex in those cases using "\\." and "\\?"
     *
     * @return
     */
    public boolean validate(String url){

        //URL has to start with "https://"
        if (!url.startsWith("https://")){
            return false;
        }
        //URL without an extension is rejected
        if(!url.matches("https://[^/]+\\.[a-zA-Z]+.*")){
            return false;
        }
        //URL that attempts to establish a path after query parameters is rejected
        if (url.matches(".+\\?.*/.*")){
            return false;
        }
        try{
            new URL(url);
            return true;
        } catch (Exception e){
            return false;
        }
    }
}
