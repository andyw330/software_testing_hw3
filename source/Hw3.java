package source;

import java.util.*;

//SeatsLeft ResetThePlane
public class Hw3 {

	public static void main(String[] args) {

		Plane B747 = new Plane();

		B747.getData();

		Scanner scan = new Scanner(System.in);

		String tempString = scan.nextLine();

		String[] tempBreak = tempString.split(" ");
		String temp;
		int tempCount = 0;
		temp = tempBreak[tempCount++];

		int tempINT;
		int[] tempTOTAL = new int[B747.typeList.length];
		int i;

		Exception EF = new Exception();
		Exception FL = new Exception();
		Exception FWSerial = new Exception();
		Exception FWSeat = new Exception();

		while (!temp.equals("exit")) {
			if (temp.equals("Register")) {
				for (i = 0; i < B747.typeList.length; i++) {
					tempTOTAL[i] = 0;
				}
				try {
					while (tempCount < tempBreak.length) {
						temp = tempBreak[tempCount];
						for (i = 0; i < B747.typeList.length; i++) {
							if (temp.equals(B747.typeList[i].type)) {
								tempCount++;
								tempINT = Integer.parseInt(tempBreak[tempCount]);
								tempTOTAL[i] = tempTOTAL[i] + tempINT;
								if (!B747.registerAble(B747.typeList[i], tempTOTAL[i])) {
									throw FL;
								}
								break;
							}
						}
						if (i == B747.typeList.length) {
							throw EF;
						}
						tempCount++;
					}
					//Register here
					B747.codeList[B747.numberCode] = new RandomCode(B747.numberCode + 1);
					for (i = 0; i < B747.typeList.length; i++) {
						B747.registerType(B747.typeList[i], tempTOTAL[i]);
					}
					B747.numberCode++;
					System.out.print("Register Success ");
					B747.codeList[B747.numberCode - 1].showCode();
					System.out.println("");
				} catch (Exception ex) {
					if (ex.equals(EF)) {
						System.out.println("Error Format");
					} else if (ex.equals(FL)) {
						System.out.println("Fail Lack");
					} else {
						System.out.println("Exception");
					}
				}
				tempCount = 0;
			} else if (temp.equals("Unregister")) {
				try {
					while (tempCount < tempBreak.length) {
						temp = tempBreak[tempCount];
						if (Character.isLetter(temp.charAt(0))) {
							if (temp.charAt(0) >= 'A' && temp.charAt(0) <= 'H') {
								String intValue = temp.replaceAll("[A-Z]", "");
								if (Integer.parseInt(intValue) < 1 || Integer.parseInt(intValue) > 70) {
									throw EF;
								}
								if (!B747.seatList[temp.charAt(0) - 'A'][Integer.parseInt(intValue)].isBookable()) {
									B747.unregisterSeat(B747.seatList[temp.charAt(0) - 'A'][Integer.parseInt(intValue)]);
								} else {
									throw FWSeat;
								}
							} else if (temp.charAt(0) >= 'J' && temp.charAt(0) <= 'K') {
								String intValue = temp.replaceAll("[A-Z]", "");
								if (Integer.parseInt(intValue) < 1 || Integer.parseInt(intValue) > 70) {
									throw EF;
								}
								if (!B747.seatList[temp.charAt(0) - 'A' - 1][Integer.parseInt(intValue)].isBookable()) {
									B747.unregisterSeat(B747.seatList[temp.charAt(0) - 'A' - 1][Integer.parseInt(intValue)]);
								}
							} else {
								throw EF;
							}
						} else if (isInteger(temp)) {
							if (temp.length() != 8) throw EF;
							int tempParseInt = Integer.parseInt(temp);
							if (tempParseInt > 0 && tempParseInt <= B747.numberCode) {
								if (!B747.codeList[tempParseInt - 1].usable) throw FWSerial;
								B747.codeList[tempParseInt - 1].unregisterCode();
							} else {
								throw FWSerial;
							}
						} else {
							throw EF;
						}
						tempCount++;
					}
					System.out.println("Unregister Success");
				} catch (Exception ex) {
					if (ex.equals(EF)) {
						System.out.println("Error Format");
					} else if (ex.equals(FL)) {
						System.out.println("Fail Lack");
					} else if (ex.equals(FWSeat)) {
						System.out.println("Fail Wrong Seat");
					} else if (ex.equals(FWSerial)) {
						System.out.println("Fail Wrong Serial");
					} else {
						System.out.println("Exception");
					}
				}
				tempCount = 0;
			} else if (temp.equals("Order")) {
				try {
					while (tempCount < tempBreak.length) {
						temp = tempBreak[tempCount];
						if (Character.isLetter(temp.charAt(0))) {
							if (temp.charAt(0) >= 'A' && temp.charAt(0) <= 'H') {
								String intValue = temp.replaceAll("[A-Z]", "");
								if (Integer.parseInt(intValue) < 1 || Integer.parseInt(intValue) > 70) {
									throw EF;
								}
								if (B747.seatList[temp.charAt(0) - 'A'][Integer.parseInt(intValue)].isRegistered()) {
									String tempSeat = temp;
									tempCount++;
									temp = tempBreak[tempCount];
									for (i = 0; i < B747.foodList.length; i++) {
										if (temp.equals(B747.foodList[i].food)) {
											B747.seatList[tempSeat.charAt(0) - 'A'][Integer.parseInt(intValue)].orderFood(B747.foodList[i]);
											break;
										}
									}
									if (i == B747.foodList.length) {
										throw EF;
									}
								} else {
									throw FWSeat;
								}
							} else if (temp.charAt(0) >= 'J' && temp.charAt(0) <= 'K') {
								String intValue = temp.replaceAll("[A-Z]", "");
								if (Integer.parseInt(intValue) < 1 || Integer.parseInt(intValue) > 70) {
									throw EF;
								}
								if (B747.seatList[temp.charAt(0) - 'A' - 1][Integer.parseInt(intValue)].isRegistered()) {
									String tempSeat = temp;
									tempCount++;
									temp = tempBreak[tempCount];
									for (i = 0; i < B747.foodList.length; i++) {
										if (temp.equals(B747.foodList[i].food)) {
											B747.seatList[tempSeat.charAt(0) - 'A' - 1][Integer.parseInt(intValue)].orderFood(B747.foodList[i]);
											break;
										}
									}
									if (i == B747.foodList.length) {
										throw EF;
									}
								} else {
									throw FWSeat;
								}
							}
						} else if (isInteger(temp)) {
							if (temp.length() != 8) throw EF;
							int tempParseInt = Integer.parseInt(temp);
							if (tempParseInt > 0 && tempParseInt <= B747.numberCode) {
								if (!B747.codeList[tempParseInt - 1].usable) throw FWSerial;
								tempCount++;
								temp = tempBreak[tempCount];
								for (i = 0; i < B747.foodList.length; i++) {
									if (temp.equals(B747.foodList[i].food)) {
										B747.codeList[tempParseInt - 1].orderFood(B747.foodList[i]);
										break;
									}
								}
								if (i == B747.foodList.length) {
									throw EF;
								}
							} else {
								throw FWSerial;
							}
						} else {
							throw EF;
						}
						tempCount++;
					}
					System.out.println("Order Success");
				} catch (Exception ex) {
					if (ex.equals(EF)) {
						System.out.println("Error Format");
					} else if (ex.equals(FL)) {
						System.out.println("Fail Lack");
					} else if (ex.equals(FWSeat)) {
						System.out.println("Fail Wrong Seat");
					} else if (ex.equals(FWSerial)) {
						System.out.println("Fail Wrong Serial");
					} else {
						System.out.println("Exception");
					}
				}
				tempCount = 0;
			} else if (temp.equals("Query")) {
				try {
					while (tempCount < tempBreak.length) {
						temp = tempBreak[tempCount];
						if (Character.isLetter(temp.charAt(0))) {
							if (temp.charAt(0) >= 'A' && temp.charAt(0) <= 'H') {
								String intValue = temp.replaceAll("[A-Z]", "");
								if (Integer.parseInt(intValue) < 1 || Integer.parseInt(intValue) > 70) {
									throw EF;
								}
								if (B747.seatList[temp.charAt(0) - 'A'][Integer.parseInt(intValue)].isRegistered()) {
									B747.seatList[temp.charAt(0) - 'A'][Integer.parseInt(intValue)].showInfo();
								} else {
									throw FWSeat;
								}
							} else if (temp.charAt(0) >= 'J' && temp.charAt(0) <= 'K') {
								String intValue = temp.replaceAll("[A-Z]", "");
								if (Integer.parseInt(intValue) < 1 || Integer.parseInt(intValue) > 70) {
									throw EF;
								}
								if (B747.seatList[temp.charAt(0) - 'A' - 1][Integer.parseInt(intValue)].isRegistered()) {
									B747.seatList[temp.charAt(0) - 'A' - 1][Integer.parseInt(intValue)].showInfo();
								}
							} else {
								throw EF;
							}
						} else if (isInteger(temp)) {
							if (temp.length() != 8) throw EF;
							int tempParseInt = Integer.parseInt(temp);
							if (tempParseInt > 0 && tempParseInt <= B747.numberCode) {
								if (!B747.codeList[tempParseInt - 1].usable) throw FWSerial;
								B747.codeList[tempParseInt - 1].showInfo();
							} else {
								throw FWSerial;
							}
						} else {
							throw EF;
						}
						tempCount++;
					}
				} catch (Exception ex) {
					if (ex.equals(EF)) {
						System.out.println("Error Format");
					} else if (ex.equals(FL)) {
						System.out.println("Fail Lack");
					} else if (ex.equals(FWSeat)) {
						System.out.println("Fail Wrong Seat");
					} else if (ex.equals(FWSerial)) {
						System.out.println("Fail Wrong Serial");
					} else {
						System.out.println("Exception");
					}
				}
				tempCount = 0;
			} else if (temp.equals("ResetThePlane")) {
				B747.resetData();
			} else if (temp.equals("SeatsLeft")) {
				System.out.println("There are " + B747.seatsLeft() + " seat(s) left.");
			} else {
				System.out.println("Error Format");
			}

			B747.saveData();

			tempString = scan.nextLine();
			tempBreak = tempString.split(" ");
			tempCount = 0;
			temp = tempBreak[tempCount++];
		}

		scan.close();
	}

	public static boolean isInteger(String s) {
		try {
			Integer.parseInt(s);
		} catch (NumberFormatException e) {
			return false;
		}
		return true;
	}

}
