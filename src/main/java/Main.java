import static spark.Spark.get;

import org.eclipse.jetty.server.Authentication;
import org.json.JSONArray;
import spark.Request;
import java.util.HashMap;
import java.util.Map;
import spark.template.velocity.*;
import spark.ModelAndView;

public class Main {
    public static void main(String[] args) {
        get("/hello", "application/json", (req, res) -> renderMap(req));
    }


    private static String renderMap(Request req) {
        Map<String, Object> model = new HashMap();

        try {
            int width = Integer.parseInt(req.queryParams("widthInput"));
            int height = Integer.parseInt(req.queryParams("heightInput"));
            int tunnels = Integer.parseInt(req.queryParams("tunnelsInput"));
            int length = Integer.parseInt(req.queryParams("lengthInput"));

            Map2D map = new Map2D(width, height, tunnels, length);
            JSONArray arrayMap = map.getMap();

            model.put("map", arrayMap);
        } catch (Exception e) {
            model.put("map", "Select Params");
        }


        return renderTemplate("velocity/mapDisplay.vm", model);
    }

    private static String renderTemplate(String template, Map model) {
        return new VelocityTemplateEngine().render(new ModelAndView(model, template));
    }
}

