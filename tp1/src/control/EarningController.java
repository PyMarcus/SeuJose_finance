package control;

import dao.impl.EarningDAOImpl;
import model.Earning;

import java.util.UUID;

/**
 * The type Earning controller.
 */
public class EarningController {

    private String enviroment;
    private EarningDAOImpl earningModel;

    /**
     * Instantiates a new Earning controller.
     *
     * @param enviroment the enviroment
     */
public EarningController(String enviroment) {
        this.enviroment = enviroment;
        earningModel = new EarningDAOImpl(this.enviroment);

    }

    /**
     * Gets total earning.
     *
     * @return the total earning
     */
public String getTotalEarning() {
        return Double.toString(earningModel.getTotalEarnings());
    }

    /**
     * Create.
     *
     * @param earning the earning
     */
public void create(Earning earning) {
        earningModel.createEarning(earning);
    }

  /**
   * Remove.
   *
   * @param uuid the uuid
   */
  public void remove(UUID uuid) {
        earningModel.removeEarning(uuid);
    }
}
