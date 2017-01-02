package iristk.app.kitchenMaid;

import java.util.List;
import java.io.File;
import iristk.xml.XmlMarshaller.XMLLocation;
import iristk.system.Event;
import iristk.flow.*;
import iristk.util.Record;
import static iristk.util.Converters.*;
import static iristk.flow.State.*;

public class RecipeFlow extends iristk.flow.Flow {

	private InstructionSet instructions;
	private Instruction instruction;
	private Measurement measure;

	private void initVariables() {
	}

	public Instruction getInstruction() {
		return this.instruction;
	}

	public void setInstruction(Instruction value) {
		this.instruction = value;
	}

	public Measurement getMeasure() {
		return this.measure;
	}

	public void setMeasure(Measurement value) {
		this.measure = value;
	}

	public InstructionSet getInstructions() {
		return this.instructions;
	}

	@Override
	public Object getVariable(String name) {
		if (name.equals("instruction")) return this.instruction;
		if (name.equals("measure")) return this.measure;
		if (name.equals("instructions")) return this.instructions;
		return null;
	}


	public RecipeFlow(InstructionSet instructions) {
		this.instructions = instructions;
		initVariables();
	}

	@Override
	public State getInitialState() {return new Start();}


	public class Start extends Dialog implements Initial {

		final State currentState = this;


		@Override
		public void setFlowThread(FlowRunner.FlowThread flowThread) {
			super.setFlowThread(flowThread);
		}

		@Override
		public void onentry() throws Exception {
			int eventResult;
			Event event = new Event("state.enter");
			// Line: 17
			try {
				EXECUTION: {
					int count = getCount(1973336893) + 1;
					incrCount(1973336893);
					iristk.flow.DialogFlow.say state0 = new iristk.flow.DialogFlow.say();
					StringCreator string1 = new StringCreator();
					string1.append("Time to do some cool baking. Are you ready?");
					state0.setText(string1.toString());
					if (!flowThread.callState(state0, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\Niklas\\IrisTK\\app\\kitchenMaid\\src\\iristk\\app\\kitchenMaid\\RecipeFlow.xml"), 17, 12)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					iristk.flow.DialogFlow.listen state2 = new iristk.flow.DialogFlow.listen();
					if (!flowThread.callState(state2, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\Niklas\\IrisTK\\app\\kitchenMaid\\src\\iristk\\app\\kitchenMaid\\RecipeFlow.xml"), 17, 12)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("C:\\Users\\Niklas\\IrisTK\\app\\kitchenMaid\\src\\iristk\\app\\kitchenMaid\\RecipeFlow.xml"), 17, 12));
			}
		}

		@Override
		public int onFlowEvent(Event event) throws Exception {
			int eventResult;
			int count;
			// Line: 21
			try {
				count = getCount(1174290147) + 1;
				if (event.triggers("sense.user.speak")) {
					if (event.has("sem:confirm")) {
						incrCount(1174290147);
						eventResult = EVENT_CONSUMED;
						EXECUTION: {
							iristk.flow.DialogFlow.say state3 = new iristk.flow.DialogFlow.say();
							StringCreator string4 = new StringCreator();
							string4.append("Cool. Lets get this party started");
							state3.setText(string4.toString());
							if (!flowThread.callState(state3, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\Niklas\\IrisTK\\app\\kitchenMaid\\src\\iristk\\app\\kitchenMaid\\RecipeFlow.xml"), 21, 62)))) {
								eventResult = EVENT_ABORTED;
								break EXECUTION;
							}
							// Line: 23
							MoveOn state5 = new MoveOn();
							flowThread.gotoState(state5, currentState, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\Niklas\\IrisTK\\app\\kitchenMaid\\src\\iristk\\app\\kitchenMaid\\RecipeFlow.xml"), 23, 26)));
							eventResult = EVENT_ABORTED;
							break EXECUTION;
						}
						if (eventResult != EVENT_IGNORED) return eventResult;
					}
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("C:\\Users\\Niklas\\IrisTK\\app\\kitchenMaid\\src\\iristk\\app\\kitchenMaid\\RecipeFlow.xml"), 21, 62));
			}
			// Line: 25
			try {
				count = getCount(1285044316) + 1;
				if (event.triggers("sense.user.speak")) {
					if (event.has("sem:no")) {
						incrCount(1285044316);
						eventResult = EVENT_CONSUMED;
						EXECUTION: {
							// Line: 26
							End state6 = new End();
							flowThread.gotoState(state6, currentState, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\Niklas\\IrisTK\\app\\kitchenMaid\\src\\iristk\\app\\kitchenMaid\\RecipeFlow.xml"), 26, 23)));
							eventResult = EVENT_ABORTED;
							break EXECUTION;
						}
						if (eventResult != EVENT_IGNORED) return eventResult;
					}
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("C:\\Users\\Niklas\\IrisTK\\app\\kitchenMaid\\src\\iristk\\app\\kitchenMaid\\RecipeFlow.xml"), 25, 57));
			}
			eventResult = super.onFlowEvent(event);
			if (eventResult != EVENT_IGNORED) return eventResult;
			eventResult = callerHandlers(event);
			if (eventResult != EVENT_IGNORED) return eventResult;
			return EVENT_IGNORED;
		}

	}


	private class MoveOn extends Dialog {

		final State currentState = this;


		@Override
		public void setFlowThread(FlowRunner.FlowThread flowThread) {
			super.setFlowThread(flowThread);
		}

		@Override
		public void onentry() throws Exception {
			int eventResult;
			Event event = new Event("state.enter");
			// Line: 31
			try {
				EXECUTION: {
					int count = getCount(1588970020) + 1;
					incrCount(1588970020);
					// Line: 32
					if (instructions.endOfRecipe()) {
						iristk.flow.DialogFlow.say state7 = new iristk.flow.DialogFlow.say();
						StringCreator string8 = new StringCreator();
						string8.append("You are finished with the recipe. Good job.");
						state7.setText(string8.toString());
						if (!flowThread.callState(state7, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\Niklas\\IrisTK\\app\\kitchenMaid\\src\\iristk\\app\\kitchenMaid\\RecipeFlow.xml"), 32, 42)))) {
							eventResult = EVENT_ABORTED;
							break EXECUTION;
						}
						// Line: 34
						End state9 = new End();
						flowThread.gotoState(state9, currentState, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\Niklas\\IrisTK\\app\\kitchenMaid\\src\\iristk\\app\\kitchenMaid\\RecipeFlow.xml"), 34, 24)));
						eventResult = EVENT_ABORTED;
						break EXECUTION;
						// Line: 35
					} else {
						// Line: 36
						instruction = instructions.next();
						// Line: 37
						Recipe state10 = new Recipe();
						flowThread.gotoState(state10, currentState, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\Niklas\\IrisTK\\app\\kitchenMaid\\src\\iristk\\app\\kitchenMaid\\RecipeFlow.xml"), 37, 27)));
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("C:\\Users\\Niklas\\IrisTK\\app\\kitchenMaid\\src\\iristk\\app\\kitchenMaid\\RecipeFlow.xml"), 31, 12));
			}
		}

		@Override
		public int onFlowEvent(Event event) throws Exception {
			int eventResult;
			int count;
			eventResult = super.onFlowEvent(event);
			if (eventResult != EVENT_IGNORED) return eventResult;
			eventResult = callerHandlers(event);
			if (eventResult != EVENT_IGNORED) return eventResult;
			return EVENT_IGNORED;
		}

	}


	private class Recipe extends Dialog {

		final State currentState = this;


		@Override
		public void setFlowThread(FlowRunner.FlowThread flowThread) {
			super.setFlowThread(flowThread);
		}

		@Override
		public void onentry() throws Exception {
			int eventResult;
			Event event = new Event("state.enter");
			// Line: 43
			try {
				EXECUTION: {
					int count = getCount(476402209) + 1;
					incrCount(476402209);
					iristk.flow.DialogFlow.say state11 = new iristk.flow.DialogFlow.say();
					state11.setText(instruction.getFullInstruction());
					if (!flowThread.callState(state11, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\Niklas\\IrisTK\\app\\kitchenMaid\\src\\iristk\\app\\kitchenMaid\\RecipeFlow.xml"), 43, 12)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					// Line: 45
					if (instruction.getTimer()) {
						// Line: 46
						Timer state12 = new Timer();
						flowThread.gotoState(state12, currentState, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\Niklas\\IrisTK\\app\\kitchenMaid\\src\\iristk\\app\\kitchenMaid\\RecipeFlow.xml"), 46, 27)));
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					iristk.flow.DialogFlow.listen state13 = new iristk.flow.DialogFlow.listen();
					if (!flowThread.callState(state13, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\Niklas\\IrisTK\\app\\kitchenMaid\\src\\iristk\\app\\kitchenMaid\\RecipeFlow.xml"), 43, 12)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("C:\\Users\\Niklas\\IrisTK\\app\\kitchenMaid\\src\\iristk\\app\\kitchenMaid\\RecipeFlow.xml"), 43, 12));
			}
		}

		@Override
		public int onFlowEvent(Event event) throws Exception {
			int eventResult;
			int count;
			// Line: 50
			try {
				count = getCount(1919892312) + 1;
				if (event.triggers("sense.user.speak")) {
					if (event.has("sem:confirm")) {
						incrCount(1919892312);
						eventResult = EVENT_CONSUMED;
						EXECUTION: {
							// Line: 51
							Wait state14 = new Wait();
							flowThread.gotoState(state14, currentState, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\Niklas\\IrisTK\\app\\kitchenMaid\\src\\iristk\\app\\kitchenMaid\\RecipeFlow.xml"), 51, 24)));
							eventResult = EVENT_ABORTED;
							break EXECUTION;
						}
						if (eventResult != EVENT_IGNORED) return eventResult;
					}
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("C:\\Users\\Niklas\\IrisTK\\app\\kitchenMaid\\src\\iristk\\app\\kitchenMaid\\RecipeFlow.xml"), 50, 62));
			}
			// Line: 53
			try {
				count = getCount(250075633) + 1;
				if (event.triggers("sense.user.speak")) {
					if (event.has("sem:no")) {
						incrCount(250075633);
						eventResult = EVENT_CONSUMED;
						EXECUTION: {
							iristk.flow.DialogFlow.say state15 = new iristk.flow.DialogFlow.say();
							StringCreator string16 = new StringCreator();
							string16.append("Okey, let me repeat");
							state15.setText(string16.toString());
							if (!flowThread.callState(state15, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\Niklas\\IrisTK\\app\\kitchenMaid\\src\\iristk\\app\\kitchenMaid\\RecipeFlow.xml"), 53, 57)))) {
								eventResult = EVENT_ABORTED;
								break EXECUTION;
							}
							iristk.flow.DialogFlow.say state17 = new iristk.flow.DialogFlow.say();
							StringCreator string18 = new StringCreator();
							string18.append("Now I'm reading the same step again");
							state17.setText(string18.toString());
							if (!flowThread.callState(state17, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\Niklas\\IrisTK\\app\\kitchenMaid\\src\\iristk\\app\\kitchenMaid\\RecipeFlow.xml"), 53, 57)))) {
								eventResult = EVENT_ABORTED;
								break EXECUTION;
							}
							// Line: 56
							Recipe state19 = new Recipe();
							flowThread.gotoState(state19, currentState, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\Niklas\\IrisTK\\app\\kitchenMaid\\src\\iristk\\app\\kitchenMaid\\RecipeFlow.xml"), 56, 26)));
							eventResult = EVENT_ABORTED;
							break EXECUTION;
						}
						if (eventResult != EVENT_IGNORED) return eventResult;
					}
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("C:\\Users\\Niklas\\IrisTK\\app\\kitchenMaid\\src\\iristk\\app\\kitchenMaid\\RecipeFlow.xml"), 53, 57));
			}
			eventResult = super.onFlowEvent(event);
			if (eventResult != EVENT_IGNORED) return eventResult;
			eventResult = callerHandlers(event);
			if (eventResult != EVENT_IGNORED) return eventResult;
			return EVENT_IGNORED;
		}

	}


	private class Timer extends Dialog {

		final State currentState = this;


		@Override
		public void setFlowThread(FlowRunner.FlowThread flowThread) {
			super.setFlowThread(flowThread);
		}

		@Override
		public void onentry() throws Exception {
			int eventResult;
			Event event = new Event("state.enter");
			// Line: 61
			try {
				EXECUTION: {
					int count = getCount(914424520) + 1;
					incrCount(914424520);
					iristk.flow.DialogFlow.say state20 = new iristk.flow.DialogFlow.say();
					StringCreator string21 = new StringCreator();
					string21.append("Setting timer for");
					state20.setText(string21.toString());
					if (!flowThread.callState(state20, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\Niklas\\IrisTK\\app\\kitchenMaid\\src\\iristk\\app\\kitchenMaid\\RecipeFlow.xml"), 61, 12)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					iristk.flow.DialogFlow.say state22 = new iristk.flow.DialogFlow.say();
					state22.setText(instruction.getAmount());
					if (!flowThread.callState(state22, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\Niklas\\IrisTK\\app\\kitchenMaid\\src\\iristk\\app\\kitchenMaid\\RecipeFlow.xml"), 61, 12)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					iristk.flow.DialogFlow.say state23 = new iristk.flow.DialogFlow.say();
					state23.setText(instruction.getMeasurement());
					if (!flowThread.callState(state23, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\Niklas\\IrisTK\\app\\kitchenMaid\\src\\iristk\\app\\kitchenMaid\\RecipeFlow.xml"), 61, 12)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					// Line: 65
					instruction.setTimer();
					// Line: 66
					timerReady state24 = new timerReady();
					flowThread.gotoState(state24, currentState, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\Niklas\\IrisTK\\app\\kitchenMaid\\src\\iristk\\app\\kitchenMaid\\RecipeFlow.xml"), 66, 31)));
					eventResult = EVENT_ABORTED;
					break EXECUTION;
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("C:\\Users\\Niklas\\IrisTK\\app\\kitchenMaid\\src\\iristk\\app\\kitchenMaid\\RecipeFlow.xml"), 61, 12));
			}
		}

		@Override
		public int onFlowEvent(Event event) throws Exception {
			int eventResult;
			int count;
			eventResult = super.onFlowEvent(event);
			if (eventResult != EVENT_IGNORED) return eventResult;
			eventResult = callerHandlers(event);
			if (eventResult != EVENT_IGNORED) return eventResult;
			return EVENT_IGNORED;
		}

	}


	private class timerReady extends Timer {

		final State currentState = this;


		@Override
		public void setFlowThread(FlowRunner.FlowThread flowThread) {
			super.setFlowThread(flowThread);
		}

		@Override
		public void onentry() throws Exception {
			int eventResult;
			Event event = new Event("state.enter");
			// Line: 71
			try {
				EXECUTION: {
					int count = getCount(204349222) + 1;
					incrCount(204349222);
					iristk.flow.DialogFlow.listen state25 = new iristk.flow.DialogFlow.listen();
					if (!flowThread.callState(state25, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\Niklas\\IrisTK\\app\\kitchenMaid\\src\\iristk\\app\\kitchenMaid\\RecipeFlow.xml"), 71, 11)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					// Line: 73
					if (instruction.isTimerReady()) {
						iristk.flow.DialogFlow.say state26 = new iristk.flow.DialogFlow.say();
						StringCreator string27 = new StringCreator();
						string27.append("Times up!!! Lets move on");
						state26.setText(string27.toString());
						if (!flowThread.callState(state26, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\Niklas\\IrisTK\\app\\kitchenMaid\\src\\iristk\\app\\kitchenMaid\\RecipeFlow.xml"), 73, 41)))) {
							eventResult = EVENT_ABORTED;
							break EXECUTION;
						}
						// Line: 75
						MoveOn state28 = new MoveOn();
						flowThread.gotoState(state28, currentState, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\Niklas\\IrisTK\\app\\kitchenMaid\\src\\iristk\\app\\kitchenMaid\\RecipeFlow.xml"), 75, 26)));
						eventResult = EVENT_ABORTED;
						break EXECUTION;
						// Line: 76
					} else {
						// Line: 77
						timerReady state29 = new timerReady();
						flowThread.gotoState(state29, currentState, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\Niklas\\IrisTK\\app\\kitchenMaid\\src\\iristk\\app\\kitchenMaid\\RecipeFlow.xml"), 77, 30)));
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("C:\\Users\\Niklas\\IrisTK\\app\\kitchenMaid\\src\\iristk\\app\\kitchenMaid\\RecipeFlow.xml"), 71, 11));
			}
		}

		@Override
		public int onFlowEvent(Event event) throws Exception {
			int eventResult;
			int count;
			eventResult = super.onFlowEvent(event);
			if (eventResult != EVENT_IGNORED) return eventResult;
			eventResult = callerHandlers(event);
			if (eventResult != EVENT_IGNORED) return eventResult;
			return EVENT_IGNORED;
		}

	}


	private class Wait extends Dialog {

		final State currentState = this;


		@Override
		public void setFlowThread(FlowRunner.FlowThread flowThread) {
			super.setFlowThread(flowThread);
		}

		@Override
		public void onentry() throws Exception {
			int eventResult;
			Event event = new Event("state.enter");
			// Line: 83
			try {
				EXECUTION: {
					int count = getCount(1023487453) + 1;
					incrCount(1023487453);
					iristk.flow.DialogFlow.say state30 = new iristk.flow.DialogFlow.say();
					StringCreator string31 = new StringCreator();
					string31.append("Let me know when you are ready");
					state30.setText(string31.toString());
					if (!flowThread.callState(state30, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\Niklas\\IrisTK\\app\\kitchenMaid\\src\\iristk\\app\\kitchenMaid\\RecipeFlow.xml"), 83, 11)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					iristk.flow.DialogFlow.listen state32 = new iristk.flow.DialogFlow.listen();
					if (!flowThread.callState(state32, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\Niklas\\IrisTK\\app\\kitchenMaid\\src\\iristk\\app\\kitchenMaid\\RecipeFlow.xml"), 83, 11)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("C:\\Users\\Niklas\\IrisTK\\app\\kitchenMaid\\src\\iristk\\app\\kitchenMaid\\RecipeFlow.xml"), 83, 11));
			}
		}

		@Override
		public int onFlowEvent(Event event) throws Exception {
			int eventResult;
			int count;
			// Line: 87
			try {
				count = getCount(515132998) + 1;
				if (event.triggers("sense.user.speak")) {
					if (event.has("sem:ready")) {
						incrCount(515132998);
						eventResult = EVENT_CONSUMED;
						EXECUTION: {
							// Line: 88
							boolean chosen33 = false;
							boolean matching34 = true;
							while (!chosen33 && matching34) {
								int rand35 = random(1694819250, 3, iristk.util.RandomList.RandomModel.DECK_RESHUFFLE_NOREPEAT);
								matching34 = false;
								if (true) {
									matching34 = true;
									if (rand35 >= 0 && rand35 < 1) {
										chosen33 = true;
										iristk.flow.DialogFlow.say state36 = new iristk.flow.DialogFlow.say();
										StringCreator string37 = new StringCreator();
										string37.append("Good, lets move on");
										state36.setText(string37.toString());
										if (!flowThread.callState(state36, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\Niklas\\IrisTK\\app\\kitchenMaid\\src\\iristk\\app\\kitchenMaid\\RecipeFlow.xml"), 88, 11)))) {
											eventResult = EVENT_ABORTED;
											break EXECUTION;
										}
									}
								}
								if (true) {
									matching34 = true;
									if (rand35 >= 1 && rand35 < 2) {
										chosen33 = true;
										iristk.flow.DialogFlow.say state38 = new iristk.flow.DialogFlow.say();
										StringCreator string39 = new StringCreator();
										string39.append("Awesome, time for the next step");
										state38.setText(string39.toString());
										if (!flowThread.callState(state38, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\Niklas\\IrisTK\\app\\kitchenMaid\\src\\iristk\\app\\kitchenMaid\\RecipeFlow.xml"), 88, 11)))) {
											eventResult = EVENT_ABORTED;
											break EXECUTION;
										}
									}
								}
								if (true) {
									matching34 = true;
									if (rand35 >= 2 && rand35 < 3) {
										chosen33 = true;
										iristk.flow.DialogFlow.say state40 = new iristk.flow.DialogFlow.say();
										StringCreator string41 = new StringCreator();
										string41.append("Whoop whoop moving on");
										state40.setText(string41.toString());
										if (!flowThread.callState(state40, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\Niklas\\IrisTK\\app\\kitchenMaid\\src\\iristk\\app\\kitchenMaid\\RecipeFlow.xml"), 88, 11)))) {
											eventResult = EVENT_ABORTED;
											break EXECUTION;
										}
									}
								}
							}
							// Line: 93
							MoveOn state42 = new MoveOn();
							flowThread.gotoState(state42, currentState, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\Niklas\\IrisTK\\app\\kitchenMaid\\src\\iristk\\app\\kitchenMaid\\RecipeFlow.xml"), 93, 25)));
							eventResult = EVENT_ABORTED;
							break EXECUTION;
						}
						if (eventResult != EVENT_IGNORED) return eventResult;
					}
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("C:\\Users\\Niklas\\IrisTK\\app\\kitchenMaid\\src\\iristk\\app\\kitchenMaid\\RecipeFlow.xml"), 87, 59));
			}
			eventResult = super.onFlowEvent(event);
			if (eventResult != EVENT_IGNORED) return eventResult;
			eventResult = callerHandlers(event);
			if (eventResult != EVENT_IGNORED) return eventResult;
			return EVENT_IGNORED;
		}

	}


	private class Dialog extends State {

		final State currentState = this;


		@Override
		public void setFlowThread(FlowRunner.FlowThread flowThread) {
			super.setFlowThread(flowThread);
		}

		@Override
		public void onentry() throws Exception {
			int eventResult;
			Event event = new Event("state.enter");
		}

		@Override
		public int onFlowEvent(Event event) throws Exception {
			int eventResult;
			int count;
			// Line: 98
			try {
				count = getCount(474675244) + 1;
				if (event.triggers("sense.user.speak")) {
					if (event.has("sem:question")) {
						incrCount(474675244);
						eventResult = EVENT_CONSUMED;
						EXECUTION: {
							// Line: 99
							if (event.get("sem:question") == "measurement") {
								// Line: 100
								Measurement state43 = new Measurement();
								flowThread.gotoState(state43, currentState, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\Niklas\\IrisTK\\app\\kitchenMaid\\src\\iristk\\app\\kitchenMaid\\RecipeFlow.xml"), 100, 32)));
								eventResult = EVENT_ABORTED;
								break EXECUTION;
								// Line: 101
							} else if (event.get("sem:question") == "ingredient") {
								// Line: 102
								Ingredient state44 = new Ingredient();
								flowThread.gotoState(state44, currentState, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\Niklas\\IrisTK\\app\\kitchenMaid\\src\\iristk\\app\\kitchenMaid\\RecipeFlow.xml"), 102, 31)));
								eventResult = EVENT_ABORTED;
								break EXECUTION;
								// Line: 103
							} else {
								iristk.flow.DialogFlow.say state45 = new iristk.flow.DialogFlow.say();
								StringCreator string46 = new StringCreator();
								string46.append("Oh no");
								state45.setText(string46.toString());
								if (!flowThread.callState(state45, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\Niklas\\IrisTK\\app\\kitchenMaid\\src\\iristk\\app\\kitchenMaid\\RecipeFlow.xml"), 99, 51)))) {
									eventResult = EVENT_ABORTED;
									break EXECUTION;
								}
							}
						}
						if (eventResult != EVENT_IGNORED) return eventResult;
					}
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("C:\\Users\\Niklas\\IrisTK\\app\\kitchenMaid\\src\\iristk\\app\\kitchenMaid\\RecipeFlow.xml"), 98, 63));
			}
			// Line: 107
			try {
				count = getCount(2111991224) + 1;
				if (event.triggers("sense.user.silence")) {
					incrCount(2111991224);
					eventResult = EVENT_CONSUMED;
					EXECUTION: {
						iristk.flow.DialogFlow.say state47 = new iristk.flow.DialogFlow.say();
						StringCreator string48 = new StringCreator();
						string48.append("How is it going");
						state47.setText(string48.toString());
						if (!flowThread.callState(state47, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\Niklas\\IrisTK\\app\\kitchenMaid\\src\\iristk\\app\\kitchenMaid\\RecipeFlow.xml"), 107, 38)))) {
							eventResult = EVENT_ABORTED;
							break EXECUTION;
						}
						// Line: 109
						flowThread.reentryState(this, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\Niklas\\IrisTK\\app\\kitchenMaid\\src\\iristk\\app\\kitchenMaid\\RecipeFlow.xml"), 109, 14)));
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					if (eventResult != EVENT_IGNORED) return eventResult;
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("C:\\Users\\Niklas\\IrisTK\\app\\kitchenMaid\\src\\iristk\\app\\kitchenMaid\\RecipeFlow.xml"), 107, 38));
			}
			// Line: 111
			try {
				count = getCount(917142466) + 1;
				if (event.triggers("sense.user.speak")) {
					incrCount(917142466);
					eventResult = EVENT_CONSUMED;
					EXECUTION: {
						iristk.flow.DialogFlow.say state49 = new iristk.flow.DialogFlow.say();
						StringCreator string50 = new StringCreator();
						string50.append("I am sorry, I didn't get that.");
						state49.setText(string50.toString());
						if (!flowThread.callState(state49, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\Niklas\\IrisTK\\app\\kitchenMaid\\src\\iristk\\app\\kitchenMaid\\RecipeFlow.xml"), 111, 36)))) {
							eventResult = EVENT_ABORTED;
							break EXECUTION;
						}
						// Line: 113
						flowThread.reentryState(this, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\Niklas\\IrisTK\\app\\kitchenMaid\\src\\iristk\\app\\kitchenMaid\\RecipeFlow.xml"), 113, 14)));
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					if (eventResult != EVENT_IGNORED) return eventResult;
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("C:\\Users\\Niklas\\IrisTK\\app\\kitchenMaid\\src\\iristk\\app\\kitchenMaid\\RecipeFlow.xml"), 111, 36));
			}
			eventResult = super.onFlowEvent(event);
			if (eventResult != EVENT_IGNORED) return eventResult;
			eventResult = callerHandlers(event);
			if (eventResult != EVENT_IGNORED) return eventResult;
			return EVENT_IGNORED;
		}

	}


	private class Measurement extends Dialog {

		final State currentState = this;


		@Override
		public void setFlowThread(FlowRunner.FlowThread flowThread) {
			super.setFlowThread(flowThread);
		}

		@Override
		public void onentry() throws Exception {
			int eventResult;
			Event event = new Event("state.enter");
			// Line: 118
			try {
				EXECUTION: {
					int count = getCount(653305407) + 1;
					incrCount(653305407);
					iristk.flow.DialogFlow.say state51 = new iristk.flow.DialogFlow.say();
					StringCreator string52 = new StringCreator();
					string52.append("Okey, let me repeat the amount");
					state51.setText(string52.toString());
					if (!flowThread.callState(state51, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\Niklas\\IrisTK\\app\\kitchenMaid\\src\\iristk\\app\\kitchenMaid\\RecipeFlow.xml"), 118, 12)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					iristk.flow.DialogFlow.say state53 = new iristk.flow.DialogFlow.say();
					state53.setText(instruction.getMeasurement());
					if (!flowThread.callState(state53, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\Niklas\\IrisTK\\app\\kitchenMaid\\src\\iristk\\app\\kitchenMaid\\RecipeFlow.xml"), 118, 12)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					// Line: 121
					Wait state54 = new Wait();
					flowThread.gotoState(state54, currentState, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\Niklas\\IrisTK\\app\\kitchenMaid\\src\\iristk\\app\\kitchenMaid\\RecipeFlow.xml"), 121, 24)));
					eventResult = EVENT_ABORTED;
					break EXECUTION;
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("C:\\Users\\Niklas\\IrisTK\\app\\kitchenMaid\\src\\iristk\\app\\kitchenMaid\\RecipeFlow.xml"), 118, 12));
			}
		}

		@Override
		public int onFlowEvent(Event event) throws Exception {
			int eventResult;
			int count;
			eventResult = super.onFlowEvent(event);
			if (eventResult != EVENT_IGNORED) return eventResult;
			eventResult = callerHandlers(event);
			if (eventResult != EVENT_IGNORED) return eventResult;
			return EVENT_IGNORED;
		}

	}


	private class Ingredient extends Dialog {

		final State currentState = this;


		@Override
		public void setFlowThread(FlowRunner.FlowThread flowThread) {
			super.setFlowThread(flowThread);
		}

		@Override
		public void onentry() throws Exception {
			int eventResult;
			Event event = new Event("state.enter");
			// Line: 126
			try {
				EXECUTION: {
					int count = getCount(604107971) + 1;
					incrCount(604107971);
					iristk.flow.DialogFlow.say state55 = new iristk.flow.DialogFlow.say();
					StringCreator string56 = new StringCreator();
					string56.append("Okey, let me repeat the ingredient");
					state55.setText(string56.toString());
					if (!flowThread.callState(state55, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\Niklas\\IrisTK\\app\\kitchenMaid\\src\\iristk\\app\\kitchenMaid\\RecipeFlow.xml"), 126, 12)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					iristk.flow.DialogFlow.say state57 = new iristk.flow.DialogFlow.say();
					state57.setText(instruction.getIngredient());
					if (!flowThread.callState(state57, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\Niklas\\IrisTK\\app\\kitchenMaid\\src\\iristk\\app\\kitchenMaid\\RecipeFlow.xml"), 126, 12)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					// Line: 129
					Wait state58 = new Wait();
					flowThread.gotoState(state58, currentState, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\Niklas\\IrisTK\\app\\kitchenMaid\\src\\iristk\\app\\kitchenMaid\\RecipeFlow.xml"), 129, 24)));
					eventResult = EVENT_ABORTED;
					break EXECUTION;
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("C:\\Users\\Niklas\\IrisTK\\app\\kitchenMaid\\src\\iristk\\app\\kitchenMaid\\RecipeFlow.xml"), 126, 12));
			}
		}

		@Override
		public int onFlowEvent(Event event) throws Exception {
			int eventResult;
			int count;
			eventResult = super.onFlowEvent(event);
			if (eventResult != EVENT_IGNORED) return eventResult;
			eventResult = callerHandlers(event);
			if (eventResult != EVENT_IGNORED) return eventResult;
			return EVENT_IGNORED;
		}

	}


	private class End extends State {

		final State currentState = this;


		@Override
		public void setFlowThread(FlowRunner.FlowThread flowThread) {
			super.setFlowThread(flowThread);
		}

		@Override
		public void onentry() throws Exception {
			int eventResult;
			Event event = new Event("state.enter");
			// Line: 134
			try {
				EXECUTION: {
					int count = getCount(1982791261) + 1;
					incrCount(1982791261);
					iristk.flow.DialogFlow.say state59 = new iristk.flow.DialogFlow.say();
					StringCreator string60 = new StringCreator();
					string60.append("Okay, goodbye");
					state59.setText(string60.toString());
					if (!flowThread.callState(state59, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\Niklas\\IrisTK\\app\\kitchenMaid\\src\\iristk\\app\\kitchenMaid\\RecipeFlow.xml"), 134, 12)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					// Line: 136
					System.exit(0);
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("C:\\Users\\Niklas\\IrisTK\\app\\kitchenMaid\\src\\iristk\\app\\kitchenMaid\\RecipeFlow.xml"), 134, 12));
			}
		}

		@Override
		public int onFlowEvent(Event event) throws Exception {
			int eventResult;
			int count;
			eventResult = super.onFlowEvent(event);
			if (eventResult != EVENT_IGNORED) return eventResult;
			eventResult = callerHandlers(event);
			if (eventResult != EVENT_IGNORED) return eventResult;
			return EVENT_IGNORED;
		}

	}


}
