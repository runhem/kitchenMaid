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

	private void initVariables() {
	}

	public Instruction getInstruction() {
		return this.instruction;
	}

	public void setInstruction(Instruction value) {
		this.instruction = value;
	}

	public InstructionSet getInstructions() {
		return this.instructions;
	}

	@Override
	public Object getVariable(String name) {
		if (name.equals("instruction")) return this.instruction;
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
			// Line: 15
			try {
				EXECUTION: {
					int count = getCount(1347137144) + 1;
					incrCount(1347137144);
					iristk.flow.DialogFlow.say state0 = new iristk.flow.DialogFlow.say();
					StringCreator string1 = new StringCreator();
					string1.append("Time to do some cool baking. Are you ready?");
					state0.setText(string1.toString());
					if (!flowThread.callState(state0, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\Frida\\IrisTK\\app\\kitchenMaid\\src\\iristk\\app\\kitchenMaid\\RecipeFlow.xml"), 15, 12)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					iristk.flow.DialogFlow.listen state2 = new iristk.flow.DialogFlow.listen();
					if (!flowThread.callState(state2, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\Frida\\IrisTK\\app\\kitchenMaid\\src\\iristk\\app\\kitchenMaid\\RecipeFlow.xml"), 15, 12)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("C:\\Users\\Frida\\IrisTK\\app\\kitchenMaid\\src\\iristk\\app\\kitchenMaid\\RecipeFlow.xml"), 15, 12));
			}
		}

		@Override
		public int onFlowEvent(Event event) throws Exception {
			int eventResult;
			int count;
			// Line: 19
			try {
				count = getCount(1973336893) + 1;
				if (event.triggers("sense.user.speak")) {
					if (event.has("sem:yes")) {
						incrCount(1973336893);
						eventResult = EVENT_CONSUMED;
						EXECUTION: {
							iristk.flow.DialogFlow.say state3 = new iristk.flow.DialogFlow.say();
							StringCreator string4 = new StringCreator();
							string4.append("Cool. Let's get this party started.");
							state3.setText(string4.toString());
							if (!flowThread.callState(state3, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\Frida\\IrisTK\\app\\kitchenMaid\\src\\iristk\\app\\kitchenMaid\\RecipeFlow.xml"), 19, 58)))) {
								eventResult = EVENT_ABORTED;
								break EXECUTION;
							}
							// Line: 21
							MoveOn state5 = new MoveOn();
							flowThread.gotoState(state5, currentState, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\Frida\\IrisTK\\app\\kitchenMaid\\src\\iristk\\app\\kitchenMaid\\RecipeFlow.xml"), 21, 26)));
							eventResult = EVENT_ABORTED;
							break EXECUTION;
						}
						if (eventResult != EVENT_IGNORED) return eventResult;
					}
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("C:\\Users\\Frida\\IrisTK\\app\\kitchenMaid\\src\\iristk\\app\\kitchenMaid\\RecipeFlow.xml"), 19, 58));
			}
			// Line: 23
			try {
				count = getCount(1174290147) + 1;
				if (event.triggers("sense.user.speak")) {
					if (event.has("sem:no")) {
						incrCount(1174290147);
						eventResult = EVENT_CONSUMED;
						EXECUTION: {
							// Line: 24
							End state6 = new End();
							flowThread.gotoState(state6, currentState, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\Frida\\IrisTK\\app\\kitchenMaid\\src\\iristk\\app\\kitchenMaid\\RecipeFlow.xml"), 24, 23)));
							eventResult = EVENT_ABORTED;
							break EXECUTION;
						}
						if (eventResult != EVENT_IGNORED) return eventResult;
					}
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("C:\\Users\\Frida\\IrisTK\\app\\kitchenMaid\\src\\iristk\\app\\kitchenMaid\\RecipeFlow.xml"), 23, 57));
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
			// Line: 29
			try {
				EXECUTION: {
					int count = getCount(1607460018) + 1;
					incrCount(1607460018);
					// Line: 30
					instruction = instructions.next();
					iristk.flow.DialogFlow.say state7 = new iristk.flow.DialogFlow.say();
					state7.setText(instruction.getFullInstruction());
					if (!flowThread.callState(state7, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\Frida\\IrisTK\\app\\kitchenMaid\\src\\iristk\\app\\kitchenMaid\\RecipeFlow.xml"), 29, 12)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					// Line: 32
					Recipe state8 = new Recipe();
					flowThread.gotoState(state8, currentState, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\Frida\\IrisTK\\app\\kitchenMaid\\src\\iristk\\app\\kitchenMaid\\RecipeFlow.xml"), 32, 25)));
					eventResult = EVENT_ABORTED;
					break EXECUTION;
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("C:\\Users\\Frida\\IrisTK\\app\\kitchenMaid\\src\\iristk\\app\\kitchenMaid\\RecipeFlow.xml"), 29, 12));
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
			// Line: 37
			try {
				EXECUTION: {
					int count = getCount(1940447180) + 1;
					incrCount(1940447180);
					iristk.flow.DialogFlow.listen state9 = new iristk.flow.DialogFlow.listen();
					if (!flowThread.callState(state9, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\Frida\\IrisTK\\app\\kitchenMaid\\src\\iristk\\app\\kitchenMaid\\RecipeFlow.xml"), 37, 12)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("C:\\Users\\Frida\\IrisTK\\app\\kitchenMaid\\src\\iristk\\app\\kitchenMaid\\RecipeFlow.xml"), 37, 12));
			}
		}

		@Override
		public int onFlowEvent(Event event) throws Exception {
			int eventResult;
			int count;
			// Line: 40
			try {
				count = getCount(245565335) + 1;
				if (event.triggers("sense.user.speak")) {
					if (event.has("sem:ok")) {
						incrCount(245565335);
						eventResult = EVENT_CONSUMED;
						EXECUTION: {
							// Line: 41
							Wait state10 = new Wait();
							flowThread.gotoState(state10, currentState, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\Frida\\IrisTK\\app\\kitchenMaid\\src\\iristk\\app\\kitchenMaid\\RecipeFlow.xml"), 41, 24)));
							eventResult = EVENT_ABORTED;
							break EXECUTION;
						}
						if (eventResult != EVENT_IGNORED) return eventResult;
					}
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("C:\\Users\\Frida\\IrisTK\\app\\kitchenMaid\\src\\iristk\\app\\kitchenMaid\\RecipeFlow.xml"), 40, 57));
			}
			// Line: 43
			try {
				count = getCount(1066376662) + 1;
				if (event.triggers("sense.user.speak")) {
					if (event.has("sem:yes")) {
						incrCount(1066376662);
						eventResult = EVENT_CONSUMED;
						EXECUTION: {
							// Line: 44
							Wait state11 = new Wait();
							flowThread.gotoState(state11, currentState, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\Frida\\IrisTK\\app\\kitchenMaid\\src\\iristk\\app\\kitchenMaid\\RecipeFlow.xml"), 44, 24)));
							eventResult = EVENT_ABORTED;
							break EXECUTION;
						}
						if (eventResult != EVENT_IGNORED) return eventResult;
					}
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("C:\\Users\\Frida\\IrisTK\\app\\kitchenMaid\\src\\iristk\\app\\kitchenMaid\\RecipeFlow.xml"), 43, 58));
			}
			// Line: 46
			try {
				count = getCount(476402209) + 1;
				if (event.triggers("sense.user.speak")) {
					if (event.has("sem:no")) {
						incrCount(476402209);
						eventResult = EVENT_CONSUMED;
						EXECUTION: {
							iristk.flow.DialogFlow.say state12 = new iristk.flow.DialogFlow.say();
							StringCreator string13 = new StringCreator();
							string13.append("Okey, let me repeat");
							state12.setText(string13.toString());
							if (!flowThread.callState(state12, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\Frida\\IrisTK\\app\\kitchenMaid\\src\\iristk\\app\\kitchenMaid\\RecipeFlow.xml"), 46, 57)))) {
								eventResult = EVENT_ABORTED;
								break EXECUTION;
							}
							iristk.flow.DialogFlow.say state14 = new iristk.flow.DialogFlow.say();
							StringCreator string15 = new StringCreator();
							string15.append("Now I'm reading the same step again");
							state14.setText(string15.toString());
							if (!flowThread.callState(state14, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\Frida\\IrisTK\\app\\kitchenMaid\\src\\iristk\\app\\kitchenMaid\\RecipeFlow.xml"), 46, 57)))) {
								eventResult = EVENT_ABORTED;
								break EXECUTION;
							}
							// Line: 49
							Recipe state16 = new Recipe();
							flowThread.gotoState(state16, currentState, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\Frida\\IrisTK\\app\\kitchenMaid\\src\\iristk\\app\\kitchenMaid\\RecipeFlow.xml"), 49, 26)));
							eventResult = EVENT_ABORTED;
							break EXECUTION;
						}
						if (eventResult != EVENT_IGNORED) return eventResult;
					}
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("C:\\Users\\Frida\\IrisTK\\app\\kitchenMaid\\src\\iristk\\app\\kitchenMaid\\RecipeFlow.xml"), 46, 57));
			}
			// Line: 51
			try {
				count = getCount(460332449) + 1;
				if (event.triggers("sense.user.speak")) {
					if (event.has("sem:question")) {
						incrCount(460332449);
						eventResult = EVENT_CONSUMED;
						EXECUTION: {
							// Line: 52
							Question state17 = new Question();
							flowThread.gotoState(state17, currentState, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\Frida\\IrisTK\\app\\kitchenMaid\\src\\iristk\\app\\kitchenMaid\\RecipeFlow.xml"), 52, 28)));
							eventResult = EVENT_ABORTED;
							break EXECUTION;
						}
						if (eventResult != EVENT_IGNORED) return eventResult;
					}
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("C:\\Users\\Frida\\IrisTK\\app\\kitchenMaid\\src\\iristk\\app\\kitchenMaid\\RecipeFlow.xml"), 51, 63));
			}
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
			// Line: 58
			try {
				EXECUTION: {
					int count = getCount(250075633) + 1;
					incrCount(250075633);
					iristk.flow.DialogFlow.say state18 = new iristk.flow.DialogFlow.say();
					StringCreator string19 = new StringCreator();
					string19.append("Let me know when you are ready");
					state18.setText(string19.toString());
					if (!flowThread.callState(state18, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\Frida\\IrisTK\\app\\kitchenMaid\\src\\iristk\\app\\kitchenMaid\\RecipeFlow.xml"), 58, 11)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					iristk.flow.DialogFlow.listen state20 = new iristk.flow.DialogFlow.listen();
					if (!flowThread.callState(state20, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\Frida\\IrisTK\\app\\kitchenMaid\\src\\iristk\\app\\kitchenMaid\\RecipeFlow.xml"), 58, 11)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("C:\\Users\\Frida\\IrisTK\\app\\kitchenMaid\\src\\iristk\\app\\kitchenMaid\\RecipeFlow.xml"), 58, 11));
			}
		}

		@Override
		public int onFlowEvent(Event event) throws Exception {
			int eventResult;
			int count;
			// Line: 62
			try {
				count = getCount(517938326) + 1;
				if (event.triggers("sense.user.speak")) {
					if (event.has("sem:ready")) {
						incrCount(517938326);
						eventResult = EVENT_CONSUMED;
						EXECUTION: {
							// Line: 63
							boolean chosen21 = false;
							boolean matching22 = true;
							while (!chosen21 && matching22) {
								int rand23 = random(914424520, 3, iristk.util.RandomList.RandomModel.DECK_RESHUFFLE_NOREPEAT);
								matching22 = false;
								if (true) {
									matching22 = true;
									if (rand23 >= 0 && rand23 < 1) {
										chosen21 = true;
										iristk.flow.DialogFlow.say state24 = new iristk.flow.DialogFlow.say();
										StringCreator string25 = new StringCreator();
										string25.append("Good, let's move on");
										state24.setText(string25.toString());
										if (!flowThread.callState(state24, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\Frida\\IrisTK\\app\\kitchenMaid\\src\\iristk\\app\\kitchenMaid\\RecipeFlow.xml"), 63, 11)))) {
											eventResult = EVENT_ABORTED;
											break EXECUTION;
										}
									}
								}
								if (true) {
									matching22 = true;
									if (rand23 >= 1 && rand23 < 2) {
										chosen21 = true;
										iristk.flow.DialogFlow.say state26 = new iristk.flow.DialogFlow.say();
										StringCreator string27 = new StringCreator();
										string27.append("Awesome, time for the next step");
										state26.setText(string27.toString());
										if (!flowThread.callState(state26, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\Frida\\IrisTK\\app\\kitchenMaid\\src\\iristk\\app\\kitchenMaid\\RecipeFlow.xml"), 63, 11)))) {
											eventResult = EVENT_ABORTED;
											break EXECUTION;
										}
									}
								}
								if (true) {
									matching22 = true;
									if (rand23 >= 2 && rand23 < 3) {
										chosen21 = true;
										iristk.flow.DialogFlow.say state28 = new iristk.flow.DialogFlow.say();
										StringCreator string29 = new StringCreator();
										string29.append("Whoop whoop, we're moving on");
										state28.setText(string29.toString());
										if (!flowThread.callState(state28, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\Frida\\IrisTK\\app\\kitchenMaid\\src\\iristk\\app\\kitchenMaid\\RecipeFlow.xml"), 63, 11)))) {
											eventResult = EVENT_ABORTED;
											break EXECUTION;
										}
									}
								}
							}
							// Line: 68
							MoveOn state30 = new MoveOn();
							flowThread.gotoState(state30, currentState, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\Frida\\IrisTK\\app\\kitchenMaid\\src\\iristk\\app\\kitchenMaid\\RecipeFlow.xml"), 68, 25)));
							eventResult = EVENT_ABORTED;
							break EXECUTION;
						}
						if (eventResult != EVENT_IGNORED) return eventResult;
					}
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("C:\\Users\\Frida\\IrisTK\\app\\kitchenMaid\\src\\iristk\\app\\kitchenMaid\\RecipeFlow.xml"), 62, 59));
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
			// Line: 73
			try {
				count = getCount(2143192188) + 1;
				if (event.triggers("sense.user.silence")) {
					incrCount(2143192188);
					eventResult = EVENT_CONSUMED;
					EXECUTION: {
						iristk.flow.DialogFlow.say state31 = new iristk.flow.DialogFlow.say();
						StringCreator string32 = new StringCreator();
						string32.append("How is it going?");
						state31.setText(string32.toString());
						if (!flowThread.callState(state31, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\Frida\\IrisTK\\app\\kitchenMaid\\src\\iristk\\app\\kitchenMaid\\RecipeFlow.xml"), 73, 38)))) {
							eventResult = EVENT_ABORTED;
							break EXECUTION;
						}
						// Line: 75
						flowThread.reentryState(this, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\Frida\\IrisTK\\app\\kitchenMaid\\src\\iristk\\app\\kitchenMaid\\RecipeFlow.xml"), 75, 14)));
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					if (eventResult != EVENT_IGNORED) return eventResult;
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("C:\\Users\\Frida\\IrisTK\\app\\kitchenMaid\\src\\iristk\\app\\kitchenMaid\\RecipeFlow.xml"), 73, 38));
			}
			// Line: 77
			try {
				count = getCount(204349222) + 1;
				if (event.triggers("sense.user.speak")) {
					incrCount(204349222);
					eventResult = EVENT_CONSUMED;
					EXECUTION: {
						iristk.flow.DialogFlow.say state33 = new iristk.flow.DialogFlow.say();
						StringCreator string34 = new StringCreator();
						string34.append("I am sorry, I didn't get that.");
						state33.setText(string34.toString());
						if (!flowThread.callState(state33, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\Frida\\IrisTK\\app\\kitchenMaid\\src\\iristk\\app\\kitchenMaid\\RecipeFlow.xml"), 77, 36)))) {
							eventResult = EVENT_ABORTED;
							break EXECUTION;
						}
						// Line: 79
						flowThread.reentryState(this, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\Frida\\IrisTK\\app\\kitchenMaid\\src\\iristk\\app\\kitchenMaid\\RecipeFlow.xml"), 79, 14)));
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					if (eventResult != EVENT_IGNORED) return eventResult;
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("C:\\Users\\Frida\\IrisTK\\app\\kitchenMaid\\src\\iristk\\app\\kitchenMaid\\RecipeFlow.xml"), 77, 36));
			}
			eventResult = super.onFlowEvent(event);
			if (eventResult != EVENT_IGNORED) return eventResult;
			eventResult = callerHandlers(event);
			if (eventResult != EVENT_IGNORED) return eventResult;
			return EVENT_IGNORED;
		}

	}


	private class Question extends Dialog {

		final State currentState = this;


		@Override
		public void setFlowThread(FlowRunner.FlowThread flowThread) {
			super.setFlowThread(flowThread);
		}

		@Override
		public void onentry() throws Exception {
			int eventResult;
			Event event = new Event("state.enter");
			// Line: 84
			try {
				EXECUTION: {
					int count = getCount(2110121908) + 1;
					incrCount(2110121908);
					iristk.flow.DialogFlow.say state35 = new iristk.flow.DialogFlow.say();
					StringCreator string36 = new StringCreator();
					string36.append("I understand you have a question?");
					state35.setText(string36.toString());
					if (!flowThread.callState(state35, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\Frida\\IrisTK\\app\\kitchenMaid\\src\\iristk\\app\\kitchenMaid\\RecipeFlow.xml"), 84, 12)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("C:\\Users\\Frida\\IrisTK\\app\\kitchenMaid\\src\\iristk\\app\\kitchenMaid\\RecipeFlow.xml"), 84, 12));
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
			// Line: 90
			try {
				EXECUTION: {
					int count = getCount(1023487453) + 1;
					incrCount(1023487453);
					iristk.flow.DialogFlow.say state37 = new iristk.flow.DialogFlow.say();
					StringCreator string38 = new StringCreator();
					string38.append("Okay, goodbye");
					state37.setText(string38.toString());
					if (!flowThread.callState(state37, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\Frida\\IrisTK\\app\\kitchenMaid\\src\\iristk\\app\\kitchenMaid\\RecipeFlow.xml"), 90, 12)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					// Line: 92
					System.exit(0);
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("C:\\Users\\Frida\\IrisTK\\app\\kitchenMaid\\src\\iristk\\app\\kitchenMaid\\RecipeFlow.xml"), 90, 12));
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
