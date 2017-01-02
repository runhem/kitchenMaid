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
						startTimer state12 = new startTimer();
						flowThread.gotoState(state12, currentState, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\Niklas\\IrisTK\\app\\kitchenMaid\\src\\iristk\\app\\kitchenMaid\\RecipeFlow.xml"), 46, 32)));
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


	private class startTimer extends Dialog {

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
					string21.append("I will help you track the time. Let me know when to set the timer");
					state20.setText(string21.toString());
					if (!flowThread.callState(state20, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\Niklas\\IrisTK\\app\\kitchenMaid\\src\\iristk\\app\\kitchenMaid\\RecipeFlow.xml"), 61, 12)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					iristk.flow.DialogFlow.listen state22 = new iristk.flow.DialogFlow.listen();
					if (!flowThread.callState(state22, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\Niklas\\IrisTK\\app\\kitchenMaid\\src\\iristk\\app\\kitchenMaid\\RecipeFlow.xml"), 61, 12)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("C:\\Users\\Niklas\\IrisTK\\app\\kitchenMaid\\src\\iristk\\app\\kitchenMaid\\RecipeFlow.xml"), 61, 12));
			}
		}

		@Override
		public int onFlowEvent(Event event) throws Exception {
			int eventResult;
			int count;
			// Line: 65
			try {
				count = getCount(425918570) + 1;
				if (event.triggers("sense.user.speak")) {
					if (event.has("sem:confirm")) {
						incrCount(425918570);
						eventResult = EVENT_CONSUMED;
						EXECUTION: {
							// Line: 66
							Timer state23 = new Timer();
							flowThread.gotoState(state23, currentState, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\Niklas\\IrisTK\\app\\kitchenMaid\\src\\iristk\\app\\kitchenMaid\\RecipeFlow.xml"), 66, 24)));
							eventResult = EVENT_ABORTED;
							break EXECUTION;
						}
						if (eventResult != EVENT_IGNORED) return eventResult;
					}
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("C:\\Users\\Niklas\\IrisTK\\app\\kitchenMaid\\src\\iristk\\app\\kitchenMaid\\RecipeFlow.xml"), 65, 62));
			}
			// Line: 68
			try {
				count = getCount(1100439041) + 1;
				if (event.triggers("sense.user.speak")) {
					if (event.has("sem:no")) {
						incrCount(1100439041);
						eventResult = EVENT_CONSUMED;
						EXECUTION: {
							iristk.flow.DialogFlow.say state24 = new iristk.flow.DialogFlow.say();
							StringCreator string25 = new StringCreator();
							string25.append("You need to set a timer for this part.");
							state24.setText(string25.toString());
							if (!flowThread.callState(state24, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\Niklas\\IrisTK\\app\\kitchenMaid\\src\\iristk\\app\\kitchenMaid\\RecipeFlow.xml"), 68, 57)))) {
								eventResult = EVENT_ABORTED;
								break EXECUTION;
							}
							// Line: 70
							startTimer state26 = new startTimer();
							flowThread.gotoState(state26, currentState, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\Niklas\\IrisTK\\app\\kitchenMaid\\src\\iristk\\app\\kitchenMaid\\RecipeFlow.xml"), 70, 30)));
							eventResult = EVENT_ABORTED;
							break EXECUTION;
						}
						if (eventResult != EVENT_IGNORED) return eventResult;
					}
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("C:\\Users\\Niklas\\IrisTK\\app\\kitchenMaid\\src\\iristk\\app\\kitchenMaid\\RecipeFlow.xml"), 68, 57));
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
			// Line: 75
			try {
				EXECUTION: {
					int count = getCount(114935352) + 1;
					incrCount(114935352);
					iristk.flow.DialogFlow.say state27 = new iristk.flow.DialogFlow.say();
					StringCreator string28 = new StringCreator();
					string28.append("Setting timer for");
					state27.setText(string28.toString());
					if (!flowThread.callState(state27, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\Niklas\\IrisTK\\app\\kitchenMaid\\src\\iristk\\app\\kitchenMaid\\RecipeFlow.xml"), 75, 12)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					iristk.flow.DialogFlow.say state29 = new iristk.flow.DialogFlow.say();
					state29.setText(instruction.getAmount());
					if (!flowThread.callState(state29, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\Niklas\\IrisTK\\app\\kitchenMaid\\src\\iristk\\app\\kitchenMaid\\RecipeFlow.xml"), 75, 12)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					iristk.flow.DialogFlow.say state30 = new iristk.flow.DialogFlow.say();
					state30.setText(instruction.getMeasurement());
					if (!flowThread.callState(state30, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\Niklas\\IrisTK\\app\\kitchenMaid\\src\\iristk\\app\\kitchenMaid\\RecipeFlow.xml"), 75, 12)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					// Line: 79
					instruction.setTimer();
					// Line: 80
					timerReady state31 = new timerReady();
					flowThread.gotoState(state31, currentState, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\Niklas\\IrisTK\\app\\kitchenMaid\\src\\iristk\\app\\kitchenMaid\\RecipeFlow.xml"), 80, 31)));
					eventResult = EVENT_ABORTED;
					break EXECUTION;
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("C:\\Users\\Niklas\\IrisTK\\app\\kitchenMaid\\src\\iristk\\app\\kitchenMaid\\RecipeFlow.xml"), 75, 12));
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
			// Line: 85
			try {
				EXECUTION: {
					int count = getCount(1023487453) + 1;
					incrCount(1023487453);
					iristk.flow.DialogFlow.listen state32 = new iristk.flow.DialogFlow.listen();
					if (!flowThread.callState(state32, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\Niklas\\IrisTK\\app\\kitchenMaid\\src\\iristk\\app\\kitchenMaid\\RecipeFlow.xml"), 85, 11)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					// Line: 87
					if (instruction.isTimerReady()) {
						iristk.flow.DialogFlow.say state33 = new iristk.flow.DialogFlow.say();
						StringCreator string34 = new StringCreator();
						string34.append("Times up!!! Lets move on");
						state33.setText(string34.toString());
						if (!flowThread.callState(state33, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\Niklas\\IrisTK\\app\\kitchenMaid\\src\\iristk\\app\\kitchenMaid\\RecipeFlow.xml"), 87, 41)))) {
							eventResult = EVENT_ABORTED;
							break EXECUTION;
						}
						// Line: 89
						MoveOn state35 = new MoveOn();
						flowThread.gotoState(state35, currentState, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\Niklas\\IrisTK\\app\\kitchenMaid\\src\\iristk\\app\\kitchenMaid\\RecipeFlow.xml"), 89, 26)));
						eventResult = EVENT_ABORTED;
						break EXECUTION;
						// Line: 90
					} else {
						// Line: 91
						timerReady state36 = new timerReady();
						flowThread.gotoState(state36, currentState, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\Niklas\\IrisTK\\app\\kitchenMaid\\src\\iristk\\app\\kitchenMaid\\RecipeFlow.xml"), 91, 30)));
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("C:\\Users\\Niklas\\IrisTK\\app\\kitchenMaid\\src\\iristk\\app\\kitchenMaid\\RecipeFlow.xml"), 85, 11));
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
			// Line: 97
			try {
				EXECUTION: {
					int count = getCount(932583850) + 1;
					incrCount(932583850);
					iristk.flow.DialogFlow.say state37 = new iristk.flow.DialogFlow.say();
					StringCreator string38 = new StringCreator();
					string38.append("Let me know when you are ready");
					state37.setText(string38.toString());
					if (!flowThread.callState(state37, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\Niklas\\IrisTK\\app\\kitchenMaid\\src\\iristk\\app\\kitchenMaid\\RecipeFlow.xml"), 97, 11)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					iristk.flow.DialogFlow.listen state39 = new iristk.flow.DialogFlow.listen();
					if (!flowThread.callState(state39, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\Niklas\\IrisTK\\app\\kitchenMaid\\src\\iristk\\app\\kitchenMaid\\RecipeFlow.xml"), 97, 11)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("C:\\Users\\Niklas\\IrisTK\\app\\kitchenMaid\\src\\iristk\\app\\kitchenMaid\\RecipeFlow.xml"), 97, 11));
			}
		}

		@Override
		public int onFlowEvent(Event event) throws Exception {
			int eventResult;
			int count;
			// Line: 101
			try {
				count = getCount(212628335) + 1;
				if (event.triggers("sense.user.speak")) {
					if (event.has("sem:ready")) {
						incrCount(212628335);
						eventResult = EVENT_CONSUMED;
						EXECUTION: {
							// Line: 102
							boolean chosen40 = false;
							boolean matching41 = true;
							while (!chosen40 && matching41) {
								int rand42 = random(1579572132, 3, iristk.util.RandomList.RandomModel.DECK_RESHUFFLE_NOREPEAT);
								matching41 = false;
								if (true) {
									matching41 = true;
									if (rand42 >= 0 && rand42 < 1) {
										chosen40 = true;
										iristk.flow.DialogFlow.say state43 = new iristk.flow.DialogFlow.say();
										StringCreator string44 = new StringCreator();
										string44.append("Good, lets move on");
										state43.setText(string44.toString());
										if (!flowThread.callState(state43, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\Niklas\\IrisTK\\app\\kitchenMaid\\src\\iristk\\app\\kitchenMaid\\RecipeFlow.xml"), 102, 11)))) {
											eventResult = EVENT_ABORTED;
											break EXECUTION;
										}
									}
								}
								if (true) {
									matching41 = true;
									if (rand42 >= 1 && rand42 < 2) {
										chosen40 = true;
										iristk.flow.DialogFlow.say state45 = new iristk.flow.DialogFlow.say();
										StringCreator string46 = new StringCreator();
										string46.append("Awesome, time for the next step");
										state45.setText(string46.toString());
										if (!flowThread.callState(state45, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\Niklas\\IrisTK\\app\\kitchenMaid\\src\\iristk\\app\\kitchenMaid\\RecipeFlow.xml"), 102, 11)))) {
											eventResult = EVENT_ABORTED;
											break EXECUTION;
										}
									}
								}
								if (true) {
									matching41 = true;
									if (rand42 >= 2 && rand42 < 3) {
										chosen40 = true;
										iristk.flow.DialogFlow.say state47 = new iristk.flow.DialogFlow.say();
										StringCreator string48 = new StringCreator();
										string48.append("Whoop whoop moving on");
										state47.setText(string48.toString());
										if (!flowThread.callState(state47, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\Niklas\\IrisTK\\app\\kitchenMaid\\src\\iristk\\app\\kitchenMaid\\RecipeFlow.xml"), 102, 11)))) {
											eventResult = EVENT_ABORTED;
											break EXECUTION;
										}
									}
								}
							}
							// Line: 107
							MoveOn state49 = new MoveOn();
							flowThread.gotoState(state49, currentState, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\Niklas\\IrisTK\\app\\kitchenMaid\\src\\iristk\\app\\kitchenMaid\\RecipeFlow.xml"), 107, 25)));
							eventResult = EVENT_ABORTED;
							break EXECUTION;
						}
						if (eventResult != EVENT_IGNORED) return eventResult;
					}
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("C:\\Users\\Niklas\\IrisTK\\app\\kitchenMaid\\src\\iristk\\app\\kitchenMaid\\RecipeFlow.xml"), 101, 59));
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
			// Line: 112
			try {
				count = getCount(2111991224) + 1;
				if (event.triggers("sense.user.speak")) {
					if (event.has("sem:question")) {
						incrCount(2111991224);
						eventResult = EVENT_CONSUMED;
						EXECUTION: {
							// Line: 113
							if (event.get("sem:question") == "measurement") {
								// Line: 114
								Measurement state50 = new Measurement();
								flowThread.gotoState(state50, currentState, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\Niklas\\IrisTK\\app\\kitchenMaid\\src\\iristk\\app\\kitchenMaid\\RecipeFlow.xml"), 114, 32)));
								eventResult = EVENT_ABORTED;
								break EXECUTION;
								// Line: 115
							} else if (event.get("sem:question") == "ingredient") {
								// Line: 116
								Ingredient state51 = new Ingredient();
								flowThread.gotoState(state51, currentState, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\Niklas\\IrisTK\\app\\kitchenMaid\\src\\iristk\\app\\kitchenMaid\\RecipeFlow.xml"), 116, 31)));
								eventResult = EVENT_ABORTED;
								break EXECUTION;
								// Line: 117
							} else {
								iristk.flow.DialogFlow.say state52 = new iristk.flow.DialogFlow.say();
								StringCreator string53 = new StringCreator();
								string53.append("Oh no");
								state52.setText(string53.toString());
								if (!flowThread.callState(state52, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\Niklas\\IrisTK\\app\\kitchenMaid\\src\\iristk\\app\\kitchenMaid\\RecipeFlow.xml"), 113, 51)))) {
									eventResult = EVENT_ABORTED;
									break EXECUTION;
								}
							}
						}
						if (eventResult != EVENT_IGNORED) return eventResult;
					}
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("C:\\Users\\Niklas\\IrisTK\\app\\kitchenMaid\\src\\iristk\\app\\kitchenMaid\\RecipeFlow.xml"), 112, 63));
			}
			// Line: 121
			try {
				count = getCount(1130478920) + 1;
				if (event.triggers("sense.user.silence")) {
					incrCount(1130478920);
					eventResult = EVENT_CONSUMED;
					EXECUTION: {
						iristk.flow.DialogFlow.say state54 = new iristk.flow.DialogFlow.say();
						StringCreator string55 = new StringCreator();
						string55.append("How is it going");
						state54.setText(string55.toString());
						if (!flowThread.callState(state54, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\Niklas\\IrisTK\\app\\kitchenMaid\\src\\iristk\\app\\kitchenMaid\\RecipeFlow.xml"), 121, 38)))) {
							eventResult = EVENT_ABORTED;
							break EXECUTION;
						}
						// Line: 123
						flowThread.reentryState(this, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\Niklas\\IrisTK\\app\\kitchenMaid\\src\\iristk\\app\\kitchenMaid\\RecipeFlow.xml"), 123, 14)));
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					if (eventResult != EVENT_IGNORED) return eventResult;
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("C:\\Users\\Niklas\\IrisTK\\app\\kitchenMaid\\src\\iristk\\app\\kitchenMaid\\RecipeFlow.xml"), 121, 38));
			}
			// Line: 125
			try {
				count = getCount(604107971) + 1;
				if (event.triggers("sense.user.speak")) {
					incrCount(604107971);
					eventResult = EVENT_CONSUMED;
					EXECUTION: {
						iristk.flow.DialogFlow.say state56 = new iristk.flow.DialogFlow.say();
						StringCreator string57 = new StringCreator();
						string57.append("I am sorry, I didn't get that.");
						state56.setText(string57.toString());
						if (!flowThread.callState(state56, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\Niklas\\IrisTK\\app\\kitchenMaid\\src\\iristk\\app\\kitchenMaid\\RecipeFlow.xml"), 125, 36)))) {
							eventResult = EVENT_ABORTED;
							break EXECUTION;
						}
						// Line: 127
						flowThread.reentryState(this, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\Niklas\\IrisTK\\app\\kitchenMaid\\src\\iristk\\app\\kitchenMaid\\RecipeFlow.xml"), 127, 14)));
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					if (eventResult != EVENT_IGNORED) return eventResult;
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("C:\\Users\\Niklas\\IrisTK\\app\\kitchenMaid\\src\\iristk\\app\\kitchenMaid\\RecipeFlow.xml"), 125, 36));
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
			// Line: 132
			try {
				EXECUTION: {
					int count = getCount(1982791261) + 1;
					incrCount(1982791261);
					iristk.flow.DialogFlow.say state58 = new iristk.flow.DialogFlow.say();
					StringCreator string59 = new StringCreator();
					string59.append("Okey, let me repeat the amount");
					state58.setText(string59.toString());
					if (!flowThread.callState(state58, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\Niklas\\IrisTK\\app\\kitchenMaid\\src\\iristk\\app\\kitchenMaid\\RecipeFlow.xml"), 132, 12)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					iristk.flow.DialogFlow.say state60 = new iristk.flow.DialogFlow.say();
					state60.setText(instruction.getMeasurement());
					if (!flowThread.callState(state60, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\Niklas\\IrisTK\\app\\kitchenMaid\\src\\iristk\\app\\kitchenMaid\\RecipeFlow.xml"), 132, 12)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					// Line: 135
					Wait state61 = new Wait();
					flowThread.gotoState(state61, currentState, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\Niklas\\IrisTK\\app\\kitchenMaid\\src\\iristk\\app\\kitchenMaid\\RecipeFlow.xml"), 135, 24)));
					eventResult = EVENT_ABORTED;
					break EXECUTION;
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("C:\\Users\\Niklas\\IrisTK\\app\\kitchenMaid\\src\\iristk\\app\\kitchenMaid\\RecipeFlow.xml"), 132, 12));
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
			// Line: 140
			try {
				EXECUTION: {
					int count = getCount(971848845) + 1;
					incrCount(971848845);
					iristk.flow.DialogFlow.say state62 = new iristk.flow.DialogFlow.say();
					StringCreator string63 = new StringCreator();
					string63.append("Okey, let me repeat the ingredient");
					state62.setText(string63.toString());
					if (!flowThread.callState(state62, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\Niklas\\IrisTK\\app\\kitchenMaid\\src\\iristk\\app\\kitchenMaid\\RecipeFlow.xml"), 140, 12)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					iristk.flow.DialogFlow.say state64 = new iristk.flow.DialogFlow.say();
					state64.setText(instruction.getIngredient());
					if (!flowThread.callState(state64, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\Niklas\\IrisTK\\app\\kitchenMaid\\src\\iristk\\app\\kitchenMaid\\RecipeFlow.xml"), 140, 12)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					// Line: 143
					Wait state65 = new Wait();
					flowThread.gotoState(state65, currentState, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\Niklas\\IrisTK\\app\\kitchenMaid\\src\\iristk\\app\\kitchenMaid\\RecipeFlow.xml"), 143, 24)));
					eventResult = EVENT_ABORTED;
					break EXECUTION;
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("C:\\Users\\Niklas\\IrisTK\\app\\kitchenMaid\\src\\iristk\\app\\kitchenMaid\\RecipeFlow.xml"), 140, 12));
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
			// Line: 148
			try {
				EXECUTION: {
					int count = getCount(758529971) + 1;
					incrCount(758529971);
					iristk.flow.DialogFlow.say state66 = new iristk.flow.DialogFlow.say();
					StringCreator string67 = new StringCreator();
					string67.append("Okay, goodbye");
					state66.setText(string67.toString());
					if (!flowThread.callState(state66, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\Niklas\\IrisTK\\app\\kitchenMaid\\src\\iristk\\app\\kitchenMaid\\RecipeFlow.xml"), 148, 12)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					// Line: 150
					System.exit(0);
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("C:\\Users\\Niklas\\IrisTK\\app\\kitchenMaid\\src\\iristk\\app\\kitchenMaid\\RecipeFlow.xml"), 148, 12));
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
