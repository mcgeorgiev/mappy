import static spark.Spark.get;
import spark.Request;
import java.util.HashMap;
import java.util.Map;
import spark.template.velocity.*;
import spark.ModelAndView;

public class Main {
    public static void main(String[] args) {
        get("/hello", (req, res) -> renderMap(req));
    }

    private static String renderMap(Request req) {
        Map<String, Object> model = new HashMap();
        model.put("test", "hi");
        return renderTemplate("velocity/mapDisplay.vm", model);
    }

    private static String renderTemplate(String template, Map model) {
        return new VelocityTemplateEngine().render(new ModelAndView(model, template));
    }
}

