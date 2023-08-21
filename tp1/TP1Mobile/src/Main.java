import control.FinanceController;
import database.*;
import model.Finance;
import util.UUIDParser;
import util.FLogger;
import util.DateParse;

public class Main {
    public static void main(String[] args){
        FinanceController fc = new FinanceController("production");
        fc.create(new Finance(UUIDParser.generateUUID(), "marcus teste", "test",14.2,
                0,
                "20/02/2000", DateParse.generateCurrentLocalTime()));
    }
}
