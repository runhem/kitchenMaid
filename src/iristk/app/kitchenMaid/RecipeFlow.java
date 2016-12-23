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
			// Line: 16
			try {
				EXECUTION: {
					int count = getCount(997608398) + 1;
					incrCount(997608398);
					iristk.flow.DialogFlow.say state0 = new iristk.flow.DialogFlow.say();
					StringCreator string1 = new StringCreator();
					string1.append("Time to do some cool baking. Are you ready?");
					state0.setText(string1.toString());
					if (!flowThread.callState(state0, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\Niklas\\IrisTK\\app\\kitchenMaid\\src\\iristk\\app\\kitchenMaid\\RecipeFlow.xml"), 16, 12)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					iristk.flow.DialogFlow.listen state2 = new iristk.flow.DialogFlow.listen();
					if (!flowThread.callState(state2, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\Niklas\\IrisTK\\app\\kitchenMaid\\src\\iristk\\app\\kitchenMaid\\RecipeFlow.xml"), 16, 12)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("C:\\Users\\Niklas\\IrisTK\\app\\kitchenMaid\\src\\iristk\\app\\kitchenMaid\\RecipeFlow.xml"), 16, 12));
			}
		}

		@Override
		public int onFlowEvent(Event event) throws Exception {
			int eventResult;
			int count;
			// Line: 20
			try {
				count = getCount(1212899836) + 1;
				if (event.triggers("sense.user.speak")) {
					if (event.has("sem:yes")) {
						incrCount(1212899836);
						eventResult = EVENT_CONSUMED;
						EXECUTION: {
							iristk.flow.DialogFlow.say state3 = new iristk.flow.DialogFlow.say();
							StringCreator string4 = new StringCreator();
							string4.append("Cool. Lets get this party started");
							state3.setText(string4.toString());
							if (!flowThread.callState(state3, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\Niklas\\IrisTK\\app\\kitchenMaid\\src\\iristk\\app\\kitchenMaid\\RecipeFlow.xml"), 20, 58)))) {
								eventResult = EVENT_ABORTED;
								break EXECUTION;
							}
							// Line: 22
							MoveOn state5 = new MoveOn();
							flowThread.gotoState(state5, currentState, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\Niklas\\IrisTK\\app\\kitchenMaid\\src\\iristk\\app\\kitchenMaid\\RecipeFlow.xml"), 22, 26)));
							eventResult = EVENT_ABORTED;
							break EXECUTION;
						}
						if (eventResult != EVENT_IGNORED) return eventResult;
					}
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("C:\\Users\\Niklas\\IrisTK\\app\\kitchenMaid\\src\\iristk\\app\\kitchenMaid\\RecipeFlow.xml"), 20, 58));
			}
			// Line: 24
			try {
				count = getCount(1289696681) + 1;
				if (event.triggers("sense.user.speak")) {
					if (event.has("sem:no")) {
						incrCount(1289696681);
						eventResult = EVENT_CONSUMED;
						EXECUTION: {
							// Line: 25
							End state6 = new End();
							flowThread.gotoState(state6, currentState, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\Niklas\\IrisTK\\app\\kitchenMaid\\src\\iristk\\app\\kitchenMaid\\RecipeFlow.xml"), 25, 23)));
							eventResult = EVENT_ABORTED;
							break EXECUTION;
						}
						if (eventResult != EVENT_IGNORED) return eventResult;
					}
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("C:\\Users\\Niklas\\IrisTK\\app\\kitchenMaid\\src\\iristk\\app\\kitchenMaid\\RecipeFlow.xml"), 24, 57));
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
			// Line: 30
			try {
				EXECUTION: {
					int count = getCount(1811075214) + 1;
					incrCount(1811075214);
					// Line: 31
					if (instructions.endOfRecipe()) {
						iristk.flow.DialogFlow.say state7 = new iristk.flow.DialogFlow.say();
						StringCreator string8 = new StringCreator();
						string8.append("You are finished with the recipe. Good job.");
						state7.setText(string8.toString());
						if (!flowThread.callState(state7, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\Niklas\\IrisTK\\app\\kitchenMaid\\src\\iristk\\app\\kitchenMaid\\RecipeFlow.xml"), 31, 41)))) {
							eventResult = EVENT_ABORTED;
							break EXECUTION;
						}
						// Line: 33
						End state9 = new End();
						flowThread.gotoState(state9, currentState, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\Niklas\\IrisTK\\app\\kitchenMaid\\src\\iristk\\app\\kitchenMaid\\RecipeFlow.xml"), 33, 22)));
						eventResult = EVENT_ABORTED;
						break EXECUTION;
						// Line: 34
					} else {
						// Line: 35
						instruction = instructions.next();
						iristk.flow.DialogFlow.say state10 = new iristk.flow.DialogFlow.say();
						state10.setText(instruction.getFullInstruction());
						if (!flowThread.callState(state10, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\Niklas\\IrisTK\\app\\kitchenMaid\\src\\iristk\\app\\kitchenMaid\\RecipeFlow.xml"), 31, 41)))) {
							eventResult = EVENT_ABORTED;
							break EXECUTION;
						}
						// Line: 37
						Recipe state11 = new Recipe();
						flowThread.gotoState(state11, currentState, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\Niklas\\IrisTK\\app\\kitchenMaid\\src\\iristk\\app\\kitchenMaid\\RecipeFlow.xml"), 37, 25)));
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("C:\\Users\\Niklas\\IrisTK\\app\\kitchenMaid\\src\\iristk\\app\\kitchenMaid\\RecipeFlow.xml"), 30, 12));
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
					int count = getCount(183264084) + 1;
					incrCount(183264084);
					iristk.flow.DialogFlow.listen state12 = new iristk.flow.DialogFlow.listen();
					if (!flowThread.callState(state12, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\Niklas\\IrisTK\\app\\kitchenMaid\\src\\iristk\\app\\kitchenMaid\\RecipeFlow.xml"), 43, 12)))) {
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
			// Line: 46
			try {
				count = getCount(476402209) + 1;
				if (event.triggers("sense.user.speak")) {
					if (event.has("sem:yes")) {
						incrCount(476402209);
						eventResult = EVENT_CONSUMED;
						EXECUTION: {
							// Line: 47
							Wait state13 = new Wait();
							flowThread.gotoState(state13, currentState, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\Niklas\\IrisTK\\app\\kitchenMaid\\src\\iristk\\app\\kitchenMaid\\RecipeFlow.xml"), 47, 24)));
							eventResult = EVENT_ABORTED;
							break EXECUTION;
						}
						if (eventResult != EVENT_IGNORED) return eventResult;
					}
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("C:\\Users\\Niklas\\IrisTK\\app\\kitchenMaid\\src\\iristk\\app\\kitchenMaid\\RecipeFlow.xml"), 46, 58));
			}
			// Line: 49
			try {
				count = getCount(460332449) + 1;
				if (event.triggers("sense.user.speak")) {
					if (event.has("sem:ok")) {
						incrCount(460332449);
						eventResult = EVENT_CONSUMED;
						EXECUTION: {
							// Line: 50
							Wait state14 = new Wait();
							flowThread.gotoState(state14, currentState, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\Niklas\\IrisTK\\app\\kitchenMaid\\src\\iristk\\app\\kitchenMaid\\RecipeFlow.xml"), 50, 24)));
							eventResult = EVENT_ABORTED;
							break EXECUTION;
						}
						if (eventResult != EVENT_IGNORED) return eventResult;
					}
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("C:\\Users\\Niklas\\IrisTK\\app\\kitchenMaid\\src\\iristk\\app\\kitchenMaid\\RecipeFlow.xml"), 49, 57));
			}
			// Line: 52
			try {
				count = getCount(1143839598) + 1;
				if (event.triggers("sense.user.speak")) {
					if (event.has("sem:no")) {
						incrCount(1143839598);
						eventResult = EVENT_CONSUMED;
						EXECUTION: {
							iristk.flow.DialogFlow.say state15 = new iristk.flow.DialogFlow.say();
							StringCreator string16 = new StringCreator();
							string16.append("Okey, let me repeat");
							state15.setText(string16.toString());
							if (!flowThread.callState(state15, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\Niklas\\IrisTK\\app\\kitchenMaid\\src\\iristk\\app\\kitchenMaid\\RecipeFlow.xml"), 52, 57)))) {
								eventResult = EVENT_ABORTED;
								break EXECUTION;
							}
							iristk.flow.DialogFlow.say state17 = new iristk.flow.DialogFlow.say();
							StringCreator string18 = new StringCreator();
							string18.append("Now I'm reading the same step again");
							state17.setText(string18.toString());
							if (!flowThread.callState(state17, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\Niklas\\IrisTK\\app\\kitchenMaid\\src\\iristk\\app\\kitchenMaid\\RecipeFlow.xml"), 52, 57)))) {
								eventResult = EVENT_ABORTED;
								break EXECUTION;
							}
							// Line: 55
							Recipe state19 = new Recipe();
							flowThread.gotoState(state19, currentState, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\Niklas\\IrisTK\\app\\kitchenMaid\\src\\iristk\\app\\kitchenMaid\\RecipeFlow.xml"), 55, 26)));
							eventResult = EVENT_ABORTED;
							break EXECUTION;
						}
						if (eventResult != EVENT_IGNORED) return eventResult;
					}
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("C:\\Users\\Niklas\\IrisTK\\app\\kitchenMaid\\src\\iristk\\app\\kitchenMaid\\RecipeFlow.xml"), 52, 57));
			}
			// Line: 57
			try {
				count = getCount(358699161) + 1;
				if (event.triggers("sense.user.speak")) {
					if (event.has("sem:question")) {
						incrCount(358699161);
						eventResult = EVENT_CONSUMED;
						EXECUTION: {
							// Line: 58
							Question state20 = new Question();
							flowThread.gotoState(state20, currentState, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\Niklas\\IrisTK\\app\\kitchenMaid\\src\\iristk\\app\\kitchenMaid\\RecipeFlow.xml"), 58, 28)));
							eventResult = EVENT_ABORTED;
							break EXECUTION;
						}
						if (eventResult != EVENT_IGNORED) return eventResult;
					}
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("C:\\Users\\Niklas\\IrisTK\\app\\kitchenMaid\\src\\iristk\\app\\kitchenMaid\\RecipeFlow.xml"), 57, 63));
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
			// Line: 64
			try {
				EXECUTION: {
					int count = getCount(425918570) + 1;
					incrCount(425918570);
					iristk.flow.DialogFlow.say state21 = new iristk.flow.DialogFlow.say();
					StringCreator string22 = new StringCreator();
					string22.append("Let me know when you are ready");
					state21.setText(string22.toString());
					if (!flowThread.callState(state21, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\Niklas\\IrisTK\\app\\kitchenMaid\\src\\iristk\\app\\kitchenMaid\\RecipeFlow.xml"), 64, 11)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					iristk.flow.DialogFlow.listen state23 = new iristk.flow.DialogFlow.listen();
					if (!flowThread.callState(state23, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\Niklas\\IrisTK\\app\\kitchenMaid\\src\\iristk\\app\\kitchenMaid\\RecipeFlow.xml"), 64, 11)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("C:\\Users\\Niklas\\IrisTK\\app\\kitchenMaid\\src\\iristk\\app\\kitchenMaid\\RecipeFlow.xml"), 64, 11));
			}
		}

		@Override
		public int onFlowEvent(Event event) throws Exception {
			int eventResult;
			int count;
			// Line: 68
			try {
				count = getCount(2143192188) + 1;
				if (event.triggers("sense.user.speak")) {
					if (event.has("sem:ready")) {
						incrCount(2143192188);
						eventResult = EVENT_CONSUMED;
						EXECUTION: {
							// Line: 69
							boolean chosen24 = false;
							boolean matching25 = true;
							while (!chosen24 && matching25) {
								int rand26 = random(1100439041, 3, iristk.util.RandomList.RandomModel.DECK_RESHUFFLE_NOREPEAT);
								matching25 = false;
								if (true) {
									matching25 = true;
									if (rand26 >= 0 && rand26 < 1) {
										chosen24 = true;
										iristk.flow.DialogFlow.say state27 = new iristk.flow.DialogFlow.say();
										StringCreator string28 = new StringCreator();
										string28.append("Good, lets move on");
										state27.setText(string28.toString());
										if (!flowThread.callState(state27, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\Niklas\\IrisTK\\app\\kitchenMaid\\src\\iristk\\app\\kitchenMaid\\RecipeFlow.xml"), 69, 11)))) {
											eventResult = EVENT_ABORTED;
											break EXECUTION;
										}
									}
								}
								if (true) {
									matching25 = true;
									if (rand26 >= 1 && rand26 < 2) {
										chosen24 = true;
										iristk.flow.DialogFlow.say state29 = new iristk.flow.DialogFlow.say();
										StringCreator string30 = new StringCreator();
										string30.append("Awesome time for the next step");
										state29.setText(string30.toString());
										if (!flowThread.callState(state29, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\Niklas\\IrisTK\\app\\kitchenMaid\\src\\iristk\\app\\kitchenMaid\\RecipeFlow.xml"), 69, 11)))) {
											eventResult = EVENT_ABORTED;
											break EXECUTION;
										}
									}
								}
								if (true) {
									matching25 = true;
									if (rand26 >= 2 && rand26 < 3) {
										chosen24 = true;
										iristk.flow.DialogFlow.say state31 = new iristk.flow.DialogFlow.say();
										StringCreator string32 = new StringCreator();
										string32.append("Whoop whoop moving on");
										state31.setText(string32.toString());
										if (!flowThread.callState(state31, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\Niklas\\IrisTK\\app\\kitchenMaid\\src\\iristk\\app\\kitchenMaid\\RecipeFlow.xml"), 69, 11)))) {
											eventResult = EVENT_ABORTED;
											break EXECUTION;
										}
									}
								}
							}
							// Line: 74
							MoveOn state33 = new MoveOn();
							flowThread.gotoState(state33, currentState, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\Niklas\\IrisTK\\app\\kitchenMaid\\src\\iristk\\app\\kitchenMaid\\RecipeFlow.xml"), 74, 25)));
							eventResult = EVENT_ABORTED;
							break EXECUTION;
						}
						if (eventResult != EVENT_IGNORED) return eventResult;
					}
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("C:\\Users\\Niklas\\IrisTK\\app\\kitchenMaid\\src\\iristk\\app\\kitchenMaid\\RecipeFlow.xml"), 68, 59));
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
			// Line: 79
			try {
				count = getCount(114935352) + 1;
				if (event.triggers("sense.user.silence")) {
					incrCount(114935352);
					eventResult = EVENT_CONSUMED;
					EXECUTION: {
						iristk.flow.DialogFlow.say state34 = new iristk.flow.DialogFlow.say();
						StringCreator string35 = new StringCreator();
						string35.append("How is it going");
						state34.setText(string35.toString());
						if (!flowThread.callState(state34, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\Niklas\\IrisTK\\app\\kitchenMaid\\src\\iristk\\app\\kitchenMaid\\RecipeFlow.xml"), 79, 38)))) {
							eventResult = EVENT_ABORTED;
							break EXECUTION;
						}
						// Line: 81
						flowThread.reentryState(this, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\Niklas\\IrisTK\\app\\kitchenMaid\\src\\iristk\\app\\kitchenMaid\\RecipeFlow.xml"), 81, 14)));
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					if (eventResult != EVENT_IGNORED) return eventResult;
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("C:\\Users\\Niklas\\IrisTK\\app\\kitchenMaid\\src\\iristk\\app\\kitchenMaid\\RecipeFlow.xml"), 79, 38));
			}
			// Line: 83
			try {
				count = getCount(32374789) + 1;
				if (event.triggers("sense.user.speak")) {
					incrCount(32374789);
					eventResult = EVENT_CONSUMED;
					EXECUTION: {
						iristk.flow.DialogFlow.say state36 = new iristk.flow.DialogFlow.say();
						StringCreator string37 = new StringCreator();
						string37.append("I am sorry, I didn't get that.");
						state36.setText(string37.toString());
						if (!flowThread.callState(state36, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\Niklas\\IrisTK\\app\\kitchenMaid\\src\\iristk\\app\\kitchenMaid\\RecipeFlow.xml"), 83, 36)))) {
							eventResult = EVENT_ABORTED;
							break EXECUTION;
						}
						// Line: 85
						flowThread.reentryState(this, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\Niklas\\IrisTK\\app\\kitchenMaid\\src\\iristk\\app\\kitchenMaid\\RecipeFlow.xml"), 85, 14)));
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					if (eventResult != EVENT_IGNORED) return eventResult;
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("C:\\Users\\Niklas\\IrisTK\\app\\kitchenMaid\\src\\iristk\\app\\kitchenMaid\\RecipeFlow.xml"), 83, 36));
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
			// Line: 90
			try {
				EXECUTION: {
					int count = getCount(515132998) + 1;
					incrCount(515132998);
					iristk.flow.DialogFlow.say state38 = new iristk.flow.DialogFlow.say();
					StringCreator string39 = new StringCreator();
					string39.append("I understand you have a question?");
					state38.setText(string39.toString());
					if (!flowThread.callState(state38, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\Niklas\\IrisTK\\app\\kitchenMaid\\src\\iristk\\app\\kitchenMaid\\RecipeFlow.xml"), 90, 12)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("C:\\Users\\Niklas\\IrisTK\\app\\kitchenMaid\\src\\iristk\\app\\kitchenMaid\\RecipeFlow.xml"), 90, 12));
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
			// Line: 96
			try {
				EXECUTION: {
					int count = getCount(1651191114) + 1;
					incrCount(1651191114);
					iristk.flow.DialogFlow.say state40 = new iristk.flow.DialogFlow.say();
					StringCreator string41 = new StringCreator();
					string41.append("Okay, goodbye");
					state40.setText(string41.toString());
					if (!flowThread.callState(state40, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\Niklas\\IrisTK\\app\\kitchenMaid\\src\\iristk\\app\\kitchenMaid\\RecipeFlow.xml"), 96, 12)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					// Line: 98
					System.exit(0);
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("C:\\Users\\Niklas\\IrisTK\\app\\kitchenMaid\\src\\iristk\\app\\kitchenMaid\\RecipeFlow.xml"), 96, 12));
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
