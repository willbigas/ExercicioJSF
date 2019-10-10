package beans.validator;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@FacesValidator
public class EmailValidator implements Validator {

    public static final String EMAIL_PATTERN = "^[_A-Za-z0-9-]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";


    @Override
    public void validate(FacesContext facesContext, UIComponent uiComponent, Object o) throws ValidatorException {
        Pattern pattern = Pattern.compile(EMAIL_PATTERN);
        Matcher matcher = pattern.matcher(o.toString());
        boolean valido = matcher.matches();

        if (!valido) {
            FacesMessage message = new FacesMessage();
            message.setSeverity(FacesMessage.SEVERITY_ERROR);
            message.setDetail("Informe um email valido");
            throw new ValidatorException(message);
        }


//        String email = o.toString();
//
//        boolean contemArroba = email.contains("@");
//        boolean contemPonto = email.contains(".");
//        boolean contemAlgoAntesdoArroba = email.split("@").length >= 2;
//
//        if (!contemArroba || !contemPonto || !contemAlgoAntesdoArroba) {
//            FacesMessage message = new FacesMessage();
//            message.setSeverity(FacesMessage.SEVERITY_ERROR);
//            message.setDetail("Informe um email valido");
//            throw new ValidatorException(message);
//
//        } else {
//
//        }
    }
}
