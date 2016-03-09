package pt.tecnico.sise.jp.curiosity.core;

public class MarsEnergy extends MarsObjects{

	private boolean chargeLevel = true;
	
	public MarsEnergy(){
		super();
		setObjecttype(MarsObjectType.ENERGY);
	}

	public boolean isChargeLevel() {
		return chargeLevel;
	}

	public void setChargeLevel(boolean chargeLevel) {
		this.chargeLevel = chargeLevel;
	}
	
}
