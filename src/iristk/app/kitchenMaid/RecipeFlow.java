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
					int count = getCount(1347137144) + 1;
					incrCount(1347137144);
					iristk.flow.DialogFlow.say state0 = new iristk.flow.DialogFlow.say();
					StringCreator string1 = new StringCreator();
					string1.append("Time to do some cool baking. Are you ready?");
					state0.setText(string1.toString());
					if (!flowThread.callState(state0, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\Frida\\IrisTK\\app\\kitchenMaid\\src\\iristk\\app\\kitchenMaid\\RecipeFlow.xml"), 16, 12)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					iristk.flow.DialogFlow.listen state2 = new iristk.flow.DialogFlow.listen();
					if (!flowThread.callState(state2, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\Frida\\IrisTK\\app\\kitchenMaid\\src\\iristk\\app\\kitchenMaid\\RecipeFlow.xml"), 16, 12)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("C:\\Users\\Frida\\IrisTK\\app\\kitchenMaid\\src\\iristk\\app\\kitchenMaid\\RecipeFlow.xml"), 16, 12));
			}
		}

		@Override
		public int onFlowEvent(Event event) throws Exception {
			int eventResult;
			int count;
			// Line: 20
			try {
				count = getCount(1973336893) + 1;
				if (event.triggers("sense.user.speak")) {
					if (event.has("sem:yes")) {
						incrCount(1973336893);
						eventResult = EVENT_CONSUMED;
						EXECUTION: {
							iristk.flow.DialogFlow.say state3 = new iristk.flow.DialogFlow.say();
							StringCreator string4 = new StringCreator();
							string4.append("Cool. Lets get this party started");
							state3.setText(string4.toString());
							if (!flowThread.callState(state3, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\Frida\\IrisTK\\app\\kitchenMaid\\src\\iristk\\app\\kitchenMaid\\RecipeFlow.xml"), 20, 58)))) {
								eventResult = EVENT_ABORTED;
								break EXECUTION;
							}
							// Line: 22
							MoveOn state5 = new MoveOn();
							flowThread.gotoState(state5, currentState, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\Frida\\IrisTK\\app\\kitchenMaid\\src\\iristk\\app\\kitchenMaid\\RecipeFlow.xml"), 22, 26)));
							eventResult = EVENT_ABORTED;
							break EXECUTION;
						}
						if (eventResult != EVENT_IGNORED) return eventResult;
					}
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("C:\\Users\\Frida\\IrisTK\\app\\kitchenMaid\\src\\iristk\\app\\kitchenMaid\\RecipeFlow.xml"), 20, 58));
			}
			// Line: 24
			try {
				count = getCount(1174290147) + 1;
				if (event.triggers("sense.user.speak")) {
					if (event.has("sem:no")) {
						incrCount(1174290147);
						eventResult = EVENT_CONSUMED;
						EXECUTION: {
							// Line: 25
							End state6 = new End();
							flowThread.gotoState(state6, currentState, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\Frida\\IrisTK\\app\\kitchenMaid\\src\\iristk\\app\\kitchenMaid\\RecipeFlow.xml"), 25, 23)));
							eventResult = EVENT_ABORTED;
							break EXECUTION;
						}
						if (eventResult != EVENT_IGNORED) return eventResult;
					}
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("C:\\Users\\Frida\\IrisTK\\app\\kitchenMaid\\src\\iristk\\app\\kitchenMaid\\RecipeFlow.xml"), 24, 57));
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
					int count = getCount(1607460018) + 1;
					incrCount(1607460018);
					// Line: 31
					if (instructions.endOfRecipe()) {
						iristk.flow.DialogFlow.say state7 = new iristk.flow.DialogFlow.say();
						StringCreator string8 = new StringCreator();
						string8.append("You are finished with the recipe. Good job.");
						state7.setText(string8.toString());
						if (!flowThread.callState(state7, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\Frida\\IrisTK\\app\\kitchenMaid\\src\\iristk\\app\\kitchenMaid\\RecipeFlow.xml"), 31, 42)))) {
							eventResult = EVENT_ABORTED;
							break EXECUTION;
						}
						// Line: 33
						End state9 = new End();
						flowThread.gotoState(state9, currentState, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\Frida\\IrisTK\\app\\kitchenMaid\\src\\iristk\\app\\kitchenMaid\\RecipeFlow.xml"), 33, 24)));
						eventResult = EVENT_ABORTED;
						break EXECUTION;
						// Line: 34
					} else {
						// Line: 35
						instruction = instructions.next();
						iristk.flow.DialogFlow.say state10 = new iristk.flow.DialogFlow.say();
						state10.setText(instruction.getFullInstruction());
						if (!flowThread.callState(state10, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\Frida\\IrisTK\\app\\kitchenMaid\\src\\iristk\\app\\kitchenMaid\\RecipeFlow.xml"), 31, 42)))) {
							eventResult = EVENT_ABORTED;
							break EXECUTION;
						}
						// Line: 37
						Recipe state11 = new Recipe();
						flowThread.gotoState(state11, currentState, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\Frida\\IrisTK\\app\\kitchenMaid\\src\\iristk\\app\\kitchenMaid\\RecipeFlow.xml"), 37, 27)));
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("C:\\Users\\Frida\\IrisTK\\app\\kitchenMaid\\src\\iristk\\app\\kitchenMaid\\RecipeFlow.xml"), 30, 12));
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
					int count = getCount(1066376662) + 1;
					incrCount(1066376662);
					iristk.flow.DialogFlow.listen state12 = new iristk.flow.DialogFlow.listen();
					if (!flowThread.callState(state12, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\Frida\\IrisTK\\app\\kitchenMaid\\src\\iristk\\app\\kitchenMaid\\RecipeFlow.xml"), 43, 12)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("C:\\Users\\Frida\\IrisTK\\app\\kitchenMaid\\src\\iristk\\app\\kitchenMaid\\RecipeFlow.xml"), 43, 12));
			}
		}

		@Override
		public int onFlowEvent(Event event) throws Exception {
			int eventResult;
			int count;
			// Line: 46
			try {
				count = getCount(183264084) + 1;
				if (event.triggers("sense.user.speak")) {
					if (event.has("sem:yes")) {
						incrCount(183264084);
						eventResult = EVENT_CONSUMED;
						EXECUTION: {
							// Line: 47
							Wait state13 = new Wait();
							flowThread.gotoState(state13, currentState, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\Frida\\IrisTK\\app\\kitchenMaid\\src\\iristk\\app\\kitchenMaid\\RecipeFlow.xml"), 47, 24)));
							eventResult = EVENT_ABORTED;
							break EXECUTION;
						}
						if (eventResult != EVENT_IGNORED) return eventResult;
					}
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("C:\\Users\\Frida\\IrisTK\\app\\kitchenMaid\\src\\iristk\\app\\kitchenMaid\\RecipeFlow.xml"), 46, 58));
			}
			// Line: 49
			try {
				count = getCount(1490180672) + 1;
				if (event.triggers("sense.user.speak")) {
					if (event.has("sem:no")) {
						incrCount(1490180672);
						eventResult = EVENT_CONSUMED;
						EXECUTION: {
							iristk.flow.DialogFlow.say state14 = new iristk.flow.DialogFlow.say();
							StringCreator string15 = new StringCreator();
							string15.append("Okey, let me repeat");
							state14.setText(string15.toString());
							if (!flowThread.callState(state14, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\Frida\\IrisTK\\app\\kitchenMaid\\src\\iristk\\app\\kitchenMaid\\RecipeFlow.xml"), 49, 57)))) {
								eventResult = EVENT_ABORTED;
								break EXECUTION;
							}
							iristk.flow.DialogFlow.say state16 = new iristk.flow.DialogFlow.say();
							StringCreator string17 = new StringCreator();
							string17.append("Now I'm reading the same step again");
							state16.setText(string17.toString());
							if (!flowThread.callState(state16, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\Frida\\IrisTK\\app\\kitchenMaid\\src\\iristk\\app\\kitchenMaid\\RecipeFlow.xml"), 49, 57)))) {
								eventResult = EVENT_ABORTED;
								break EXECUTION;
							}
							// Line: 52
							Recipe state18 = new Recipe();
							flowThread.gotoState(state18, currentState, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\Frida\\IrisTK\\app\\kitchenMaid\\src\\iristk\\app\\kitchenMaid\\RecipeFlow.xml"), 52, 26)));
							eventResult = EVENT_ABORTED;
							break EXECUTION;
						}
						if (eventResult != EVENT_IGNORED) return eventResult;
					}
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("C:\\Users\\Frida\\IrisTK\\app\\kitchenMaid\\src\\iristk\\app\\kitchenMaid\\RecipeFlow.xml"), 49, 57));
			}
			// Line: 54
			try {
				count = getCount(1919892312) + 1;
				if (event.triggers("sense.user.speak")) {
					if (event.has("sem:question")) {
						incrCount(1919892312);
						eventResult = EVENT_CONSUMED;
						EXECUTION: {
							// Line: 55
							if (event.get("sem:question") == "ingredient") {
								// Line: 56
								IngredientQuestion state19 = new IngredientQuestion();
								flowThread.gotoState(state19, currentState, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\Frida\\IrisTK\\app\\kitchenMaid\\src\\iristk\\app\\kitchenMaid\\RecipeFlow.xml"), 56, 39)));
								eventResult = EVENT_ABORTED;
								break EXECUTION;
								// Line: 57
							} else if (event.get("sem:question") == "container") {
								// Line: 58
								ContainerQuestion state20 = new ContainerQuestion();
								flowThread.gotoState(state20, currentState, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\Frida\\IrisTK\\app\\kitchenMaid\\src\\iristk\\app\\kitchenMaid\\RecipeFlow.xml"), 58, 38)));
								eventResult = EVENT_ABORTED;
								break EXECUTION;
								// Line: 59
							} else {
								iristk.flow.DialogFlow.say state21 = new iristk.flow.DialogFlow.say();
								StringCreator string22 = new StringCreator();
								string22.append("There is something wrong with the question");
								state21.setText(string22.toString());
								if (!flowThread.callState(state21, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\Frida\\IrisTK\\app\\kitchenMaid\\src\\iristk\\app\\kitchenMaid\\RecipeFlow.xml"), 55, 50)))) {
									eventResult = EVENT_ABORTED;
									break EXECUTION;
								}
							}
						}
						if (eventResult != EVENT_IGNORED) return eventResult;
					}
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("C:\\Users\\Frida\\IrisTK\\app\\kitchenMaid\\src\\iristk\\app\\kitchenMaid\\RecipeFlow.xml"), 54, 63));
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
			// Line: 67
			try {
				EXECUTION: {
					int count = getCount(2143192188) + 1;
					incrCount(2143192188);
					iristk.flow.DialogFlow.say state23 = new iristk.flow.DialogFlow.say();
					StringCreator string24 = new StringCreator();
					string24.append("Let me know when you are ready");
					state23.setText(string24.toString());
					if (!flowThread.callState(state23, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\Frida\\IrisTK\\app\\kitchenMaid\\src\\iristk\\app\\kitchenMaid\\RecipeFlow.xml"), 67, 11)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					iristk.flow.DialogFlow.listen state25 = new iristk.flow.DialogFlow.listen();
					if (!flowThread.callState(state25, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\Frida\\IrisTK\\app\\kitchenMaid\\src\\iristk\\app\\kitchenMaid\\RecipeFlow.xml"), 67, 11)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("C:\\Users\\Frida\\IrisTK\\app\\kitchenMaid\\src\\iristk\\app\\kitchenMaid\\RecipeFlow.xml"), 67, 11));
			}
		}

		@Override
		public int onFlowEvent(Event event) throws Exception {
			int eventResult;
			int count;
			// Line: 71
			try {
				count = getCount(1100439041) + 1;
				if (event.triggers("sense.user.speak")) {
					if (event.has("sem:ready")) {
						incrCount(1100439041);
						eventResult = EVENT_CONSUMED;
						EXECUTION: {
							// Line: 72
							boolean chosen26 = false;
							boolean matching27 = true;
							while (!chosen26 && matching27) {
								int rand28 = random(204349222, 3, iristk.util.RandomList.RandomModel.DECK_RESHUFFLE_NOREPEAT);
								matching27 = false;
								if (true) {
									matching27 = true;
									if (rand28 >= 0 && rand28 < 1) {
										chosen26 = true;
										iristk.flow.DialogFlow.say state29 = new iristk.flow.DialogFlow.say();
										StringCreator string30 = new StringCreator();
										string30.append("Good, lets move on");
										state29.setText(string30.toString());
										if (!flowThread.callState(state29, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\Frida\\IrisTK\\app\\kitchenMaid\\src\\iristk\\app\\kitchenMaid\\RecipeFlow.xml"), 72, 11)))) {
											eventResult = EVENT_ABORTED;
											break EXECUTION;
										}
									}
								}
								if (true) {
									matching27 = true;
									if (rand28 >= 1 && rand28 < 2) {
										chosen26 = true;
										iristk.flow.DialogFlow.say state31 = new iristk.flow.DialogFlow.say();
										StringCreator string32 = new StringCreator();
										string32.append("Awesome time for the next step");
										state31.setText(string32.toString());
										if (!flowThread.callState(state31, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\Frida\\IrisTK\\app\\kitchenMaid\\src\\iristk\\app\\kitchenMaid\\RecipeFlow.xml"), 72, 11)))) {
											eventResult = EVENT_ABORTED;
											break EXECUTION;
										}
									}
								}
								if (true) {
									matching27 = true;
									if (rand28 >= 2 && rand28 < 3) {
										chosen26 = true;
										iristk.flow.DialogFlow.say state33 = new iristk.flow.DialogFlow.say();
										StringCreator string34 = new StringCreator();
										string34.append("Whoop whoop moving on");
										state33.setText(string34.toString());
										if (!flowThread.callState(state33, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\Frida\\IrisTK\\app\\kitchenMaid\\src\\iristk\\app\\kitchenMaid\\RecipeFlow.xml"), 72, 11)))) {
											eventResult = EVENT_ABORTED;
											break EXECUTION;
										}
									}
								}
							}
							// Line: 77
							MoveOn state35 = new MoveOn();
							flowThread.gotoState(state35, currentState, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\Frida\\IrisTK\\app\\kitchenMaid\\src\\iristk\\app\\kitchenMaid\\RecipeFlow.xml"), 77, 25)));
							eventResult = EVENT_ABORTED;
							break EXECUTION;
						}
						if (eventResult != EVENT_IGNORED) return eventResult;
					}
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("C:\\Users\\Frida\\IrisTK\\app\\kitchenMaid\\src\\iristk\\app\\kitchenMaid\\RecipeFlow.xml"), 71, 59));
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
			// Line: 82
			try {
				count = getCount(2110121908) + 1;
				if (event.triggers("sense.user.silence")) {
					incrCount(2110121908);
					eventResult = EVENT_CONSUMED;
					EXECUTION: {
						iristk.flow.DialogFlow.say state36 = new iristk.flow.DialogFlow.say();
						StringCreator string37 = new StringCreator();
						string37.append("How is it going");
						state36.setText(string37.toString());
						if (!flowThread.callState(state36, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\Frida\\IrisTK\\app\\kitchenMaid\\src\\iristk\\app\\kitchenMaid\\RecipeFlow.xml"), 82, 38)))) {
							eventResult = EVENT_ABORTED;
							break EXECUTION;
						}
						// Line: 84
						flowThread.reentryState(this, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\Frida\\IrisTK\\app\\kitchenMaid\\src\\iristk\\app\\kitchenMaid\\RecipeFlow.xml"), 84, 14)));
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					if (eventResult != EVENT_IGNORED) return eventResult;
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("C:\\Users\\Frida\\IrisTK\\app\\kitchenMaid\\src\\iristk\\app\\kitchenMaid\\RecipeFlow.xml"), 82, 38));
			}
			// Line: 86
			try {
				count = getCount(1023487453) + 1;
				if (event.triggers("sense.user.speak")) {
					incrCount(1023487453);
					eventResult = EVENT_CONSUMED;
					EXECUTION: {
						iristk.flow.DialogFlow.say state38 = new iristk.flow.DialogFlow.say();
						StringCreator string39 = new StringCreator();
						string39.append("I am sorry, I didn't get that.");
						state38.setText(string39.toString());
						if (!flowThread.callState(state38, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\Frida\\IrisTK\\app\\kitchenMaid\\src\\iristk\\app\\kitchenMaid\\RecipeFlow.xml"), 86, 36)))) {
							eventResult = EVENT_ABORTED;
							break EXECUTION;
						}
						// Line: 88
						flowThread.reentryState(this, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\Frida\\IrisTK\\app\\kitchenMaid\\src\\iristk\\app\\kitchenMaid\\RecipeFlow.xml"), 88, 14)));
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					if (eventResult != EVENT_IGNORED) return eventResult;
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("C:\\Users\\Frida\\IrisTK\\app\\kitchenMaid\\src\\iristk\\app\\kitchenMaid\\RecipeFlow.xml"), 86, 36));
			}
			eventResult = super.onFlowEvent(event);
			if (eventResult != EVENT_IGNORED) return eventResult;
			eventResult = callerHandlers(event);
			if (eventResult != EVENT_IGNORED) return eventResult;
			return EVENT_IGNORED;
		}

	}


	private class IngredientQuestion extends Dialog {

		final State currentState = this;


		@Override
		public void setFlowThread(FlowRunner.FlowThread flowThread) {
			super.setFlowThread(flowThread);
		}

		@Override
		public void onentry() throws Exception {
			int eventResult;
			Event event = new Event("state.enter");
			// Line: 93
			try {
				EXECUTION: {
					int count = getCount(1365202186) + 1;
					incrCount(1365202186);
					iristk.flow.DialogFlow.say state40 = new iristk.flow.DialogFlow.say();
					StringCreator string41 = new StringCreator();
					string41.append("Oh no do you have trouble with your eggs?");
					state40.setText(string41.toString());
					if (!flowThread.callState(state40, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\Frida\\IrisTK\\app\\kitchenMaid\\src\\iristk\\app\\kitchenMaid\\RecipeFlow.xml"), 93, 12)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					iristk.flow.DialogFlow.say state42 = new iristk.flow.DialogFlow.say();
					StringCreator string43 = new StringCreator();
					string43.append("I'm now answering your question. Do you understand?");
					state42.setText(string43.toString());
					if (!flowThread.callState(state42, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\Frida\\IrisTK\\app\\kitchenMaid\\src\\iristk\\app\\kitchenMaid\\RecipeFlow.xml"), 93, 12)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					// Line: 96
					QuestionAnswer state44 = new QuestionAnswer();
					flowThread.gotoState(state44, currentState, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\Frida\\IrisTK\\app\\kitchenMaid\\src\\iristk\\app\\kitchenMaid\\RecipeFlow.xml"), 96, 34)));
					eventResult = EVENT_ABORTED;
					break EXECUTION;
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("C:\\Users\\Frida\\IrisTK\\app\\kitchenMaid\\src\\iristk\\app\\kitchenMaid\\RecipeFlow.xml"), 93, 12));
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


	private class ContainerQuestion extends Dialog {

		final State currentState = this;


		@Override
		public void setFlowThread(FlowRunner.FlowThread flowThread) {
			super.setFlowThread(flowThread);
		}

		@Override
		public void onentry() throws Exception {
			int eventResult;
			Event event = new Event("state.enter");
			// Line: 102
			try {
				EXECUTION: {
					int count = getCount(474675244) + 1;
					incrCount(474675244);
					iristk.flow.DialogFlow.say state45 = new iristk.flow.DialogFlow.say();
					StringCreator string46 = new StringCreator();
					string46.append("Oh no do you have trouble with your container?");
					state45.setText(string46.toString());
					if (!flowThread.callState(state45, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\Frida\\IrisTK\\app\\kitchenMaid\\src\\iristk\\app\\kitchenMaid\\RecipeFlow.xml"), 102, 12)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					iristk.flow.DialogFlow.say state47 = new iristk.flow.DialogFlow.say();
					StringCreator string48 = new StringCreator();
					string48.append("I'm now answering your question. Do you understand?");
					state47.setText(string48.toString());
					if (!flowThread.callState(state47, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\Frida\\IrisTK\\app\\kitchenMaid\\src\\iristk\\app\\kitchenMaid\\RecipeFlow.xml"), 102, 12)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					// Line: 105
					QuestionAnswer state49 = new QuestionAnswer();
					flowThread.gotoState(state49, currentState, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\Frida\\IrisTK\\app\\kitchenMaid\\src\\iristk\\app\\kitchenMaid\\RecipeFlow.xml"), 105, 34)));
					eventResult = EVENT_ABORTED;
					break EXECUTION;
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("C:\\Users\\Frida\\IrisTK\\app\\kitchenMaid\\src\\iristk\\app\\kitchenMaid\\RecipeFlow.xml"), 102, 12));
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


	private class QuestionAnswer extends Dialog {

		final State currentState = this;


		@Override
		public void setFlowThread(FlowRunner.FlowThread flowThread) {
			super.setFlowThread(flowThread);
		}

		@Override
		public void onentry() throws Exception {
			int eventResult;
			Event event = new Event("state.enter");
			// Line: 110
			try {
				EXECUTION: {
					int count = getCount(1579572132) + 1;
					incrCount(1579572132);
					iristk.flow.DialogFlow.listen state50 = new iristk.flow.DialogFlow.listen();
					if (!flowThread.callState(state50, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\Frida\\IrisTK\\app\\kitchenMaid\\src\\iristk\\app\\kitchenMaid\\RecipeFlow.xml"), 110, 12)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("C:\\Users\\Frida\\IrisTK\\app\\kitchenMaid\\src\\iristk\\app\\kitchenMaid\\RecipeFlow.xml"), 110, 12));
			}
		}

		@Override
		public int onFlowEvent(Event event) throws Exception {
			int eventResult;
			int count;
			// Line: 113
			try {
				count = getCount(359023572) + 1;
				if (event.triggers("sense.user.speak")) {
					if (event.has("sem:yes")) {
						incrCount(359023572);
						eventResult = EVENT_CONSUMED;
						EXECUTION: {
							iristk.flow.DialogFlow.say state51 = new iristk.flow.DialogFlow.say();
							StringCreator string52 = new StringCreator();
							string52.append("Good");
							state51.setText(string52.toString());
							if (!flowThread.callState(state51, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\Frida\\IrisTK\\app\\kitchenMaid\\src\\iristk\\app\\kitchenMaid\\RecipeFlow.xml"), 113, 58)))) {
								eventResult = EVENT_ABORTED;
								break EXECUTION;
							}
							// Line: 115
							Wait state53 = new Wait();
							flowThread.gotoState(state53, currentState, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\Frida\\IrisTK\\app\\kitchenMaid\\src\\iristk\\app\\kitchenMaid\\RecipeFlow.xml"), 115, 24)));
							eventResult = EVENT_ABORTED;
							break EXECUTION;
						}
						if (eventResult != EVENT_IGNORED) return eventResult;
					}
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("C:\\Users\\Frida\\IrisTK\\app\\kitchenMaid\\src\\iristk\\app\\kitchenMaid\\RecipeFlow.xml"), 113, 58));
			}
			// Line: 117
			try {
				count = getCount(2111991224) + 1;
				if (event.triggers("sense.user.speak")) {
					if (event.has("sem:no")) {
						incrCount(2111991224);
						eventResult = EVENT_CONSUMED;
						EXECUTION: {
							iristk.flow.DialogFlow.say state54 = new iristk.flow.DialogFlow.say();
							StringCreator string55 = new StringCreator();
							string55.append("Okey, too bad");
							state54.setText(string55.toString());
							if (!flowThread.callState(state54, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\Frida\\IrisTK\\app\\kitchenMaid\\src\\iristk\\app\\kitchenMaid\\RecipeFlow.xml"), 117, 57)))) {
								eventResult = EVENT_ABORTED;
								break EXECUTION;
							}
							// Line: 119
							Wait state56 = new Wait();
							flowThread.gotoState(state56, currentState, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\Frida\\IrisTK\\app\\kitchenMaid\\src\\iristk\\app\\kitchenMaid\\RecipeFlow.xml"), 119, 24)));
							eventResult = EVENT_ABORTED;
							break EXECUTION;
						}
						if (eventResult != EVENT_IGNORED) return eventResult;
					}
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("C:\\Users\\Frida\\IrisTK\\app\\kitchenMaid\\src\\iristk\\app\\kitchenMaid\\RecipeFlow.xml"), 117, 57));
			}
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
			// Line: 124
			try {
				EXECUTION: {
					int count = getCount(1993134103) + 1;
					incrCount(1993134103);
					iristk.flow.DialogFlow.say state57 = new iristk.flow.DialogFlow.say();
					StringCreator string58 = new StringCreator();
					string58.append("Okay, goodbye");
					state57.setText(string58.toString());
					if (!flowThread.callState(state57, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\Frida\\IrisTK\\app\\kitchenMaid\\src\\iristk\\app\\kitchenMaid\\RecipeFlow.xml"), 124, 12)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					// Line: 126
					System.exit(0);
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("C:\\Users\\Frida\\IrisTK\\app\\kitchenMaid\\src\\iristk\\app\\kitchenMaid\\RecipeFlow.xml"), 124, 12));
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
