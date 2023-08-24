package control;

import dao.impl.SpendingDAOImpl;
import model.Spending;
import java.util.UUID;

/**
 * The type Spending controller.
 */
public class SpendingController {

    private String enviroment;
    private SpendingDAOImpl spendingModel;

    /**
     * Instantiates a new Spending controller.
     *
     * @param enviroment the enviroment
     */
public SpendingController(String enviroment) {
        this.enviroment = enviroment;
        spendingModel = new SpendingDAOImpl(this.enviroment);

    }

    /**
     * Gets total spendings.
     *
     * @return the total spendings
     */
public String getTotalSpendings() {
        return Double.toString(spendingModel.getTotalSpendings());
    }

    /**
     * Create.
     *
     * @param spending the spending
     */
public void create(Spending spending) {
        spendingModel.createSpending(spending);
    }

  /**
   * Remove.
   *
   * @param uuid the uuid
   */
  public void remove(UUID uuid) {
        spendingModel.removeSpending(uuid);
    }
}
