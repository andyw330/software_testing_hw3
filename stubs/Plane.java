package stubs;

import java.io.*;

public class Plane {

	public SeatType[] planeSeatTypes = new SeatType[TYPE.number];
	public Seat[]
	A = new Seat[72],
	B = new Seat[72],
	C = new Seat[72],
	D = new Seat[72],
	E = new Seat[72],
	F = new Seat[72],
	G = new Seat[72],
	H = new Seat[72],
	J = new Seat[72],
	K = new Seat[72];

	public Seat[][] seatList = new Seat[10][];
	public FoodOrder[] foodList = new FoodOrder[4];
	public SeatType[] typeList = new SeatType[4];
	public RandomCode[] codeList = new RandomCode[99999];

	public int numberCode = 0;

	public void boot() {
		seatList[0] = A;
		seatList[1] = B;
		seatList[2] = C;
		seatList[3] = D;
		seatList[4] = E;
		seatList[5] = F;
		seatList[6] = G;
		seatList[7] = H;
		seatList[8] = J;
		seatList[9] = K;
		foodList[0] = FOOD.NONE;
		foodList[1] = FOOD.VEGETABLE;
		foodList[2] = FOOD.PORK;
		foodList[3] = FOOD.BEEF;
		typeList[0] = TYPE.EC;
		typeList[1] = TYPE.EDC;
		typeList[2] = TYPE.SBC;
		typeList[3] = TYPE.SFC;
	}

	public void insertSeats() {

		planeSeatTypes[0] = TYPE.SFC;
		planeSeatTypes[1] = TYPE.SBC;
		planeSeatTypes[2] = TYPE.EDC;
		planeSeatTypes[3] = TYPE.EC;

		//Making seats
		for (int j = 0; j <= 70; j++) {
			A[j] = B[j] = C[j] = D[j] = E[j] = F[j] = G[j] = H[j] = J[j] = K[j] = new Seat();
		}

		//Inserting seats
		for (int i = 0; i <= 1; i++) {
			for (int j = planeSeatTypes[i].seatStart; j <= planeSeatTypes[i].seatEnd; j++) {
				A[j] = new Seat(planeSeatTypes[i], j, 'A');
				C[j] = new Seat(planeSeatTypes[i], j, 'C');
				H[j] = new Seat(planeSeatTypes[i], j, 'H');
				K[j] = new Seat(planeSeatTypes[i], j, 'K');
				//A[j] = C[j] = H[j] = K[j] = new Seat(planeSeatTypes[i], j);
			}
		}
		for (int i = 2; i <= 2; i++) {
			for (int j = planeSeatTypes[i].seatStart; j <= planeSeatTypes[i].seatEnd; j++) {
				A[j] = new Seat(planeSeatTypes[i], j, 'A');
				C[j] = new Seat(planeSeatTypes[i], j, 'C');
				D[j] = new Seat(planeSeatTypes[i], j, 'D');
				E[j] = new Seat(planeSeatTypes[i], j, 'E');
				F[j] = new Seat(planeSeatTypes[i], j, 'F');
				G[j] = new Seat(planeSeatTypes[i], j, 'G');
				H[j] = new Seat(planeSeatTypes[i], j, 'H');
				K[j] = new Seat(planeSeatTypes[i], j, 'K');
				//A[j] = C[j] = D[j] = E[j] = F[j] = G[j] = H[j] = K[j] = new Seat(planeSeatTypes[i], j);
			}
		}
		for (int i = 3; i <= 3; i++) {
			for (int j = planeSeatTypes[i].seatStart; j <= planeSeatTypes[i].seatEnd; j++) {
				A[j] = new Seat(planeSeatTypes[i], j, 'A');
				B[j] = new Seat(planeSeatTypes[i], j, 'B');
				C[j] = new Seat(planeSeatTypes[i], j, 'C');
				D[j] = new Seat(planeSeatTypes[i], j, 'D');
				E[j] = new Seat(planeSeatTypes[i], j, 'E');
				F[j] = new Seat(planeSeatTypes[i], j, 'F');
				G[j] = new Seat(planeSeatTypes[i], j, 'G');
				H[j] = new Seat(planeSeatTypes[i], j, 'H');
				J[j] = new Seat(planeSeatTypes[i], j, 'J');
				K[j] = new Seat(planeSeatTypes[i], j, 'K');
				//A[j] = B[j] = C[j] = D[j] = E[j] = F[j] = G[j] = H[j] = J[j] = K[j] = new Seat(planeSeatTypes[i], j);
			}
		}
	}

	public void removeRowA(int row) {
		A[row].notAvailable();
	}
	public void removeRowB(int row) {
		B[row].notAvailable();
	}
	public void removeRowC(int row) {
		C[row].notAvailable();
	}
	public void removeRowD(int row) {
		D[row].notAvailable();
	}
	public void removeRowE(int row) {
		E[row].notAvailable();
	}
	public void removeRowF(int row) {
		F[row].notAvailable();
	}
	public void removeRowG(int row) {
		G[row].notAvailable();
	}
	public void removeRowH(int row) {
		H[row].notAvailable();
	}
	public void removeRowJ(int row) {
		J[row].notAvailable();
	}
	public void removeRowK(int row) {
		K[row].notAvailable();
	}

	//Making a new plane
	public Plane() {

		boot();

		insertSeats();

		//Removing seats
		removeRowD(45);
		removeRowE(45);
		removeRowF(45);
		removeRowG(45);
		for (int i = 54; i <= 59; i++) {
			removeRowD(i);
			removeRowE(i);
			removeRowF(i);
			removeRowG(i);
		}
		for (int i = 67; i <= 69; i++) {
			removeRowB(i);
			removeRowJ(i);
		}
		removeRowA(70);
		removeRowB(70);
		removeRowC(70);
		removeRowH(70);
		removeRowJ(70);
		removeRowK(70);

	}

	public int seatsLeft() {
		int temp = 0;
		for (int i = 0; i < seatList.length; i++) {
			for (int j = 0; j <= 70; j++) {
				if (this.seatList[i][j].isBookable()) {
					temp++;
				}
			}
		}
		return temp;
	}

	public int seatsLeft(SeatType tempType) {
		int temp = 0;
		for (int i = 0; i < this.seatList.length; i++) {
			for (int j = tempType.seatStart; j <= tempType.seatEnd; j++) {
				if (this.seatList[i][j].isBookable()) {
					temp++;
				}
			}
		}
		return temp;
	}

	public boolean registerAble(SeatType tempType, int nums) {
		if (seatsLeft(tempType) >= nums) {
			return true;
		} else {
			return false;
		}
	}

	public void unregisterSeat(Seat temp) {
		this.codeList[temp.getCode() - 1].removeSeat(temp);
		temp.unregister();
	}

	public void registerType(SeatType tempType, int nums) {
		if (nums < 1) return;
		for (int i = 0; i < this.typeList.length; i++) {
			if (tempType.type.equals(this.typeList[i].type)) {
				for (int j = tempType.seatStart; j <= tempType.seatEnd; j++) {
					for (int k = 0; k < this.seatList.length; k++) {
						if (nums < 1) {
							return;
						}
						if (this.seatList[k][j].isBookable()) {
							this.seatList[k][j].register(this.numberCode + 1);
							codeList[numberCode].addSeat(this.seatList[k][j]);
							nums--;
						}
					}

				}
			}
			if (nums < 1) {
				return;
			}
		}
	}

	public void resetData() {
		FileInputStream fin;
		BufferedReader reader;
		try {
			fin = new FileInputStream("memBACKUP.txt");
			reader = new BufferedReader(new InputStreamReader(fin));
			String tempString;
			String[] tempBreak = new String[400];
			String temp;
			int tempCount = 0;
			int tempReg;
			String tempFood;
			int tempCode;
			int tempSeats;
			String tempName;
			int tempUsable;
			for (int i = 0; i < this.seatList.length; i++) {
				for (int j = 0; j < 70; j++) {
					tempCount = 0;
					tempString = reader.readLine();
					tempBreak = tempString.split(" ");
					temp = tempBreak[tempCount++];
					temp = tempBreak[tempCount++];
					tempReg = Integer.parseInt(temp);
					temp = tempBreak[tempCount++];
					tempFood = temp;
					temp = tempBreak[tempCount++];
					tempCode = Integer.parseInt(temp);
					if (tempReg == 1) {
						this.seatList[i][j].register(tempCode);
						for (int k = 0; k < this.foodList.length; k++) {
							if (tempFood.equals(this.foodList[k].food)) {
								this.seatList[i][j].orderFood(this.foodList[k]);
								break;
							}
						}
					} else {
						this.seatList[i][j].unregister();
						this.seatList[i][j].orderFood(FOOD.NONE);
					}
				}
			}
			tempString = reader.readLine();
			tempCode = Integer.parseInt(tempString);
			this.numberCode = tempCode;
			for (int i = 0; i < tempCode; i++) {
				this.codeList[i] = new RandomCode(i + 1);
				tempCount = 0;
				tempString = reader.readLine();
				tempBreak = tempString.split(" ");
				temp = tempBreak[tempCount++];
				tempSeats = Integer.parseInt(temp);
				if (tempSeats > 1)
					for (int k = 0; k < tempSeats; k++) {
						temp = tempBreak[tempCount++];
						tempName = temp;
						if (tempName.charAt(0) >= 'A' && tempName.charAt(0) <= 'H') {
							String intValue = temp.replaceAll("[A-Z]", "");
							this.codeList[i].addSeat(this.seatList[tempName.charAt(0) - 'A'][Integer.parseInt(intValue)]);
						} else if (temp.charAt(0) >= 'J' && temp.charAt(0) <= 'K') {
							String intValue = temp.replaceAll("[A-Z]", "");
							this.codeList[i].addSeat(this.seatList[tempName.charAt(0) - 'A' - 1][Integer.parseInt(intValue)]);
						}
					}
				temp = tempBreak[tempCount++];
				tempUsable = Integer.parseInt(temp);
				if (tempUsable == 1) {
					this.codeList[i].usable = true;
				} else {
					this.codeList[i].usable = false;
				}
			}
			fin.close();
		} catch (Exception ex) {
			System.out.println("Data could not be reset.");
			return;
		}
		this.saveData();
		System.out.println("Data is reset.");
	}

	public void getData() {
		FileInputStream fin;
		BufferedReader reader;
		try {
			fin = new FileInputStream("mem.txt");
			reader = new BufferedReader(new InputStreamReader(fin));
			String tempString;
			String[] tempBreak = new String[400];
			String temp;
			int tempCount = 0;
			int tempReg;
			String tempFood;
			int tempCode;
			int tempSeats;
			String tempName;
			int tempUsable;
			for (int i = 0; i < this.seatList.length; i++) {
				for (int j = 0; j < 70; j++) {
					tempCount = 0;
					tempString = reader.readLine();
					tempBreak = tempString.split(" ");
					temp = tempBreak[tempCount++];
					temp = tempBreak[tempCount++];
					tempReg = Integer.parseInt(temp);
					temp = tempBreak[tempCount++];
					tempFood = temp;
					temp = tempBreak[tempCount++];
					tempCode = Integer.parseInt(temp);
					if (tempReg == 1) {
						this.seatList[i][j].register(tempCode);
						for (int k = 0; k < this.foodList.length; k++) {
							if (tempFood.equals(this.foodList[k].food)) {
								this.seatList[i][j].orderFood(this.foodList[k]);
								break;
							}
						}
					} else {
						this.seatList[i][j].unregister();
						this.seatList[i][j].orderFood(FOOD.NONE);
					}
				}
			}
			tempString = reader.readLine();
			tempCode = Integer.parseInt(tempString);
			this.numberCode = tempCode;
			for (int i = 0; i < tempCode; i++) {
				this.codeList[i] = new RandomCode(i + 1);
				tempCount = 0;
				tempString = reader.readLine();
				tempBreak = tempString.split(" ");
				temp = tempBreak[tempCount++];
				tempSeats = Integer.parseInt(temp);
				if (tempSeats == 0) this.codeList[i].usable = false;
				for (int k = 0; k < tempSeats; k++) {
					temp = tempBreak[tempCount++];
					tempName = temp;
					if (tempName.charAt(0) >= 'A' && tempName.charAt(0) <= 'H') {
						String intValue = temp.replaceAll("[A-Z]", "");
						this.codeList[i].addSeat(this.seatList[tempName.charAt(0) - 'A'][Integer.parseInt(intValue)]);
					} else if (temp.charAt(0) >= 'J' && temp.charAt(0) <= 'K') {
						String intValue = temp.replaceAll("[A-Z]", "");
						this.codeList[i].addSeat(this.seatList[tempName.charAt(0) - 'A' - 1][Integer.parseInt(intValue)]);
					}
				}
				temp = tempBreak[tempCount++];
				tempUsable = Integer.parseInt(temp);
				if (tempUsable == 1) {
					this.codeList[i].usable = true;
				} else {
					this.codeList[i].usable = false;
				}
			}
			fin.close();
		} catch (Exception ex) {
			System.out.println("Data is corrupted and will be reset.");
			this.resetData();
			return;
		}
	}

	public void saveData() {
		FileOutputStream fout;
		try {
			byte[] buf;
			fout = new FileOutputStream("mem.txt");

			for (int i = 0; i < this.seatList.length; i++) {
				for (int j = 0; j < 70; j++) {
					if (this.seatList[i][j].isAvailable()) {
						buf = "1 ".getBytes();
					} else {
						buf = "0 ".getBytes();
					}
					fout.write(buf);

					if (this.seatList[i][j].isRegistered()) {
						buf = "1 ".getBytes();
					} else {
						buf = "0 ".getBytes();
					}
					fout.write(buf);

					buf = this.seatList[i][j].foodType().getBytes();
					fout.write(buf);

					buf = " ".getBytes();
					fout.write(buf);

					buf = String.valueOf(this.seatList[i][j].getCode()).getBytes();
					fout.write(buf);

					buf = "\n".getBytes();
					fout.write(buf);
				}
			}

			buf = String.valueOf(this.numberCode).getBytes();
			fout.write(buf);

			buf = "\n".getBytes();
			fout.write(buf);

			for (int i = 0; i < this.numberCode; i++) {
				buf = String.valueOf(this.codeList[i].numberSeats()).getBytes();
				fout.write(buf);

				buf = " ".getBytes();
				fout.write(buf);

				for (int j = 0; j < this.codeList[i].numberSeats(); j++) {
					buf = this.codeList[i].seats[j].seatName.getBytes();
					fout.write(buf);

					buf = " ".getBytes();
					fout.write(buf);
				}

				if (this.codeList[i].usable) {
					buf = "1".getBytes();
				} else {
					buf = "0".getBytes();
				}
				fout.write(buf);

				buf = "\n".getBytes();
				fout.write(buf);
			}
			fout.close();
		} catch (Exception ex) {
			System.out.println("File write fail.");
			return;
		}
	}
}
