package uz.qodirov.jsonrpcclent;

import com.jayway.jsonpath.DocumentContext;
import com.jayway.jsonpath.JsonPath;

public class Test {
    public static void main(String[] args) {
        String json = """
                {
                    "tool":\s
                    {
                        "jsonpath":\s
                        {
                            "creator":\s
                            {
                                "name": "Jayway Inc.",
                                "location":\s
                                [
                                    "Malmo",
                                    "San Francisco",
                                    "Helsingborg"
                                ]
                            }
                        }
                    },

                    "book":\s
                    [
                        {
                            "title": "Beginning JSON",
                            "price": 49.99
                        },

                        {
                            "title": "JSON at Work",
                            "price": 29.99
                        }
                    ]
                }""";
        String jsonpathCreatorNamePath = "$['tool']['jsonpath']['creator']['name']";
        String jsonpathCreatorLocationPath = "$['tool']['jsonpath']['creator']['location'][*]";
        DocumentContext jsonContext = JsonPath.parse(json);
        System.out.println("jsonContext.read(jsonpathCreatorNamePath) = " + jsonContext.read(jsonpathCreatorNamePath));
        System.out.println("jsonContext.read(jsonpathCreatorLocationPath) = " + jsonContext.read(jsonpathCreatorLocationPath));
    }
}

