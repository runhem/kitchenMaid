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
	private AnimateMe animation;
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

	public AnimateMe getAnimation() {
		return this.animation;
	}

	@Override
	public Object getVariable(String name) {
		if (name.equals("instruction")) return this.instruction;
		if (name.equals("measure")) return this.measure;
		if (name.equals("instructions")) return this.instructions;
		if (name.equals("animation")) return this.animation;
		return null;
	}


	public RecipeFlow(InstructionSet instructions, AnimateMe animation) {
		this.instructions = instructions;
		this.animation = animation;
		initVariables();
	}

	@Override
	public State getInitialState() {return new goAhead();}


	public class goAhead extends State implements Initial {

		final State currentState = this;


		@Override
		public void setFlowThread(FlowRunner.FlowThread flowThread) {
			super.setFlowThread(flowThread);
		}

		@Override
		public void onentry() throws Exception {
			int eventResult;
			Event event = new Event("state.enter");
			// Line: 18
			try {
				EXECUTION: {
					int count = getCount(1212899836) + 1;
					incrCount(1212899836);
					iristk.flow.DialogFlow.listen state0 = new iristk.flow.DialogFlow.listen();
					if (!flowThread.callState(state0, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\Niklas\\IrisTK\\app\\kitchenMaid\\src\\iristk\\app\\kitchenMaid\\RecipeFlow.xml"), 18, 12)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("C:\\Users\\Niklas\\IrisTK\\app\\kitchenMaid\\src\\iristk\\app\\kitchenMaid\\RecipeFlow.xml"), 18, 12));
			}
		}

		@Override
		public int onFlowEvent(Event event) throws Exception {
			int eventResult;
			int count;
			// Line: 21
			try {
				count = getCount(1289696681) + 1;
				if (event.triggers("sense.user.speak")) {
					incrCount(1289696681);
					eventResult = EVENT_CONSUMED;
					EXECUTION: {
						// Line: 22
						if (event.has("sem:wakeUp")) {
							// Line: 23
							Start state1 = new Start();
							flowThread.gotoState(state1, currentState, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\Niklas\\IrisTK\\app\\kitchenMaid\\src\\iristk\\app\\kitchenMaid\\RecipeFlow.xml"), 23, 26)));
							eventResult = EVENT_ABORTED;
							break EXECUTION;
							// Line: 24
						} else {
							// Line: 25
							goAhead state2 = new goAhead();
							flowThread.gotoState(state2, currentState, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\Niklas\\IrisTK\\app\\kitchenMaid\\src\\iristk\\app\\kitchenMaid\\RecipeFlow.xml"), 25, 28)));
							eventResult = EVENT_ABORTED;
							break EXECUTION;
						}
					}
					if (eventResult != EVENT_IGNORED) return eventResult;
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("C:\\Users\\Niklas\\IrisTK\\app\\kitchenMaid\\src\\iristk\\app\\kitchenMaid\\RecipeFlow.xml"), 21, 36));
			}
			eventResult = super.onFlowEvent(event);
			if (eventResult != EVENT_IGNORED) return eventResult;
			eventResult = callerHandlers(event);
			if (eventResult != EVENT_IGNORED) return eventResult;
			return EVENT_IGNORED;
		}

	}


	private class Start extends Dialog {

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
					int count = getCount(1940447180) + 1;
					incrCount(1940447180);
					// Line: 31
					animation.setVisible(true);
					iristk.flow.DialogFlow.say state3 = new iristk.flow.DialogFlow.say();
					StringCreator string4 = new StringCreator();
					string4.append("Time to do some cool baking. Are you ready?");
					state3.setText(string4.toString());
					if (!flowThread.callState(state3, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\Niklas\\IrisTK\\app\\kitchenMaid\\src\\iristk\\app\\kitchenMaid\\RecipeFlow.xml"), 30, 12)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					// Line: 33
					animation.setListen();
					iristk.flow.DialogFlow.listen state5 = new iristk.flow.DialogFlow.listen();
					if (!flowThread.callState(state5, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\Niklas\\IrisTK\\app\\kitchenMaid\\src\\iristk\\app\\kitchenMaid\\RecipeFlow.xml"), 30, 12)))) {
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
			// Line: 36
			try {
				count = getCount(1066376662) + 1;
				if (event.triggers("sense.user.speak")) {
					if (event.has("sem:confirm")) {
						incrCount(1066376662);
						eventResult = EVENT_CONSUMED;
						EXECUTION: {
							// Line: 37
							animation.setTalk();
							iristk.flow.DialogFlow.say state6 = new iristk.flow.DialogFlow.say();
							StringCreator string7 = new StringCreator();
							string7.append("Cool. Lets get this party started");
							state6.setText(string7.toString());
							if (!flowThread.callState(state6, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\Niklas\\IrisTK\\app\\kitchenMaid\\src\\iristk\\app\\kitchenMaid\\RecipeFlow.xml"), 36, 62)))) {
								eventResult = EVENT_ABORTED;
								break EXECUTION;
							}
							// Line: 39
							MoveOn state8 = new MoveOn();
							flowThread.gotoState(state8, currentState, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\Niklas\\IrisTK\\app\\kitchenMaid\\src\\iristk\\app\\kitchenMaid\\RecipeFlow.xml"), 39, 26)));
							eventResult = EVENT_ABORTED;
							break EXECUTION;
						}
						if (eventResult != EVENT_IGNORED) return eventResult;
					}
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("C:\\Users\\Niklas\\IrisTK\\app\\kitchenMaid\\src\\iristk\\app\\kitchenMaid\\RecipeFlow.xml"), 36, 62));
			}
			// Line: 41
			try {
				count = getCount(1490180672) + 1;
				if (event.triggers("sense.user.speak")) {
					if (event.has("sem:no")) {
						incrCount(1490180672);
						eventResult = EVENT_CONSUMED;
						EXECUTION: {
							// Line: 42
							End state9 = new End();
							flowThread.gotoState(state9, currentState, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\Niklas\\IrisTK\\app\\kitchenMaid\\src\\iristk\\app\\kitchenMaid\\RecipeFlow.xml"), 42, 23)));
							eventResult = EVENT_ABORTED;
							break EXECUTION;
						}
						if (eventResult != EVENT_IGNORED) return eventResult;
					}
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("C:\\Users\\Niklas\\IrisTK\\app\\kitchenMaid\\src\\iristk\\app\\kitchenMaid\\RecipeFlow.xml"), 41, 57));
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
			// Line: 47
			try {
				EXECUTION: {
					int count = getCount(1143839598) + 1;
					incrCount(1143839598);
					// Line: 48
					if (instructions.endOfRecipe()) {
						// Line: 49
						animation.setTalk();
						iristk.flow.DialogFlow.say state10 = new iristk.flow.DialogFlow.say();
						StringCreator string11 = new StringCreator();
						string11.append("You are finished with the recipe. Good job.");
						state10.setText(string11.toString());
						if (!flowThread.callState(state10, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\Niklas\\IrisTK\\app\\kitchenMaid\\src\\iristk\\app\\kitchenMaid\\RecipeFlow.xml"), 48, 42)))) {
							eventResult = EVENT_ABORTED;
							break EXECUTION;
						}
						// Line: 51
						End state12 = new End();
						flowThread.gotoState(state12, currentState, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\Niklas\\IrisTK\\app\\kitchenMaid\\src\\iristk\\app\\kitchenMaid\\RecipeFlow.xml"), 51, 24)));
						eventResult = EVENT_ABORTED;
						break EXECUTION;
						// Line: 52
					} else {
						// Line: 53
						instruction = instructions.next();
						// Line: 54
						Recipe state13 = new Recipe();
						flowThread.gotoState(state13, currentState, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\Niklas\\IrisTK\\app\\kitchenMaid\\src\\iristk\\app\\kitchenMaid\\RecipeFlow.xml"), 54, 27)));
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("C:\\Users\\Niklas\\IrisTK\\app\\kitchenMaid\\src\\iristk\\app\\kitchenMaid\\RecipeFlow.xml"), 47, 12));
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
			// Line: 60
			try {
				EXECUTION: {
					int count = getCount(1100439041) + 1;
					incrCount(1100439041);
					// Line: 61
					animation.setTalk();
					iristk.flow.DialogFlow.say state14 = new iristk.flow.DialogFlow.say();
					state14.setText(instruction.getFullInstruction());
					if (!flowThread.callState(state14, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\Niklas\\IrisTK\\app\\kitchenMaid\\src\\iristk\\app\\kitchenMaid\\RecipeFlow.xml"), 60, 12)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					// Line: 63
					if (instruction.getTimer()) {
						// Line: 64
						startTimer state15 = new startTimer();
						flowThread.gotoState(state15, currentState, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\Niklas\\IrisTK\\app\\kitchenMaid\\src\\iristk\\app\\kitchenMaid\\RecipeFlow.xml"), 64, 32)));
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					// Line: 66
					animation.setListen();
					iristk.flow.DialogFlow.listen state16 = new iristk.flow.DialogFlow.listen();
					if (!flowThread.callState(state16, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\Niklas\\IrisTK\\app\\kitchenMaid\\src\\iristk\\app\\kitchenMaid\\RecipeFlow.xml"), 60, 12)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("C:\\Users\\Niklas\\IrisTK\\app\\kitchenMaid\\src\\iristk\\app\\kitchenMaid\\RecipeFlow.xml"), 60, 12));
			}
		}

		@Override
		public int onFlowEvent(Event event) throws Exception {
			int eventResult;
			int count;
			// Line: 69
			try {
				count = getCount(1973538135) + 1;
				if (event.triggers("sense.user.speak")) {
					if (event.has("sem:confirm")) {
						incrCount(1973538135);
						eventResult = EVENT_CONSUMED;
						EXECUTION: {
							// Line: 70
							Wait state17 = new Wait();
							flowThread.gotoState(state17, currentState, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\Niklas\\IrisTK\\app\\kitchenMaid\\src\\iristk\\app\\kitchenMaid\\RecipeFlow.xml"), 70, 24)));
							eventResult = EVENT_ABORTED;
							break EXECUTION;
						}
						if (eventResult != EVENT_IGNORED) return eventResult;
					}
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("C:\\Users\\Niklas\\IrisTK\\app\\kitchenMaid\\src\\iristk\\app\\kitchenMaid\\RecipeFlow.xml"), 69, 62));
			}
			// Line: 72
			try {
				count = getCount(1865127310) + 1;
				if (event.triggers("sense.user.speak")) {
					if (event.has("sem:no")) {
						incrCount(1865127310);
						eventResult = EVENT_CONSUMED;
						EXECUTION: {
							// Line: 73
							animation.setTalk();
							iristk.flow.DialogFlow.say state18 = new iristk.flow.DialogFlow.say();
							StringCreator string19 = new StringCreator();
							string19.append("Okey, let me repeat");
							state18.setText(string19.toString());
							if (!flowThread.callState(state18, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\Niklas\\IrisTK\\app\\kitchenMaid\\src\\iristk\\app\\kitchenMaid\\RecipeFlow.xml"), 72, 57)))) {
								eventResult = EVENT_ABORTED;
								break EXECUTION;
							}
							// Line: 75
							Recipe state20 = new Recipe();
							flowThread.gotoState(state20, currentState, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\Niklas\\IrisTK\\app\\kitchenMaid\\src\\iristk\\app\\kitchenMaid\\RecipeFlow.xml"), 75, 26)));
							eventResult = EVENT_ABORTED;
							break EXECUTION;
						}
						if (eventResult != EVENT_IGNORED) return eventResult;
					}
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("C:\\Users\\Niklas\\IrisTK\\app\\kitchenMaid\\src\\iristk\\app\\kitchenMaid\\RecipeFlow.xml"), 72, 57));
			}
			// Line: 77
			try {
				count = getCount(1365202186) + 1;
				if (event.triggers("sense.user.speak")) {
					if (event.has("sem:question")) {
						incrCount(1365202186);
						eventResult = EVENT_CONSUMED;
						EXECUTION: {
							// Line: 78
							if (event.get("sem:question") == "measurement") {
								// Line: 79
								Measurement state21 = new Measurement();
								flowThread.gotoState(state21, currentState, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\Niklas\\IrisTK\\app\\kitchenMaid\\src\\iristk\\app\\kitchenMaid\\RecipeFlow.xml"), 79, 32)));
								eventResult = EVENT_ABORTED;
								break EXECUTION;
								// Line: 80
							} else if (event.get("sem:question") == "ingredient") {
								// Line: 81
								Ingredient state22 = new Ingredient();
								flowThread.gotoState(state22, currentState, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\Niklas\\IrisTK\\app\\kitchenMaid\\src\\iristk\\app\\kitchenMaid\\RecipeFlow.xml"), 81, 31)));
								eventResult = EVENT_ABORTED;
								break EXECUTION;
								// Line: 82
							} else {
								iristk.flow.DialogFlow.say state23 = new iristk.flow.DialogFlow.say();
								StringCreator string24 = new StringCreator();
								string24.append("Oh no");
								state23.setText(string24.toString());
								if (!flowThread.callState(state23, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\Niklas\\IrisTK\\app\\kitchenMaid\\src\\iristk\\app\\kitchenMaid\\RecipeFlow.xml"), 78, 51)))) {
									eventResult = EVENT_ABORTED;
									break EXECUTION;
								}
							}
						}
						if (eventResult != EVENT_IGNORED) return eventResult;
					}
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("C:\\Users\\Niklas\\IrisTK\\app\\kitchenMaid\\src\\iristk\\app\\kitchenMaid\\RecipeFlow.xml"), 77, 63));
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
			// Line: 89
			try {
				EXECUTION: {
					int count = getCount(359023572) + 1;
					incrCount(359023572);
					iristk.flow.DialogFlow.say state25 = new iristk.flow.DialogFlow.say();
					StringCreator string26 = new StringCreator();
					string26.append("I will help you track the time. Let me know when to set the timer");
					state25.setText(string26.toString());
					if (!flowThread.callState(state25, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\Niklas\\IrisTK\\app\\kitchenMaid\\src\\iristk\\app\\kitchenMaid\\RecipeFlow.xml"), 89, 12)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					iristk.flow.DialogFlow.listen state27 = new iristk.flow.DialogFlow.listen();
					if (!flowThread.callState(state27, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\Niklas\\IrisTK\\app\\kitchenMaid\\src\\iristk\\app\\kitchenMaid\\RecipeFlow.xml"), 89, 12)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("C:\\Users\\Niklas\\IrisTK\\app\\kitchenMaid\\src\\iristk\\app\\kitchenMaid\\RecipeFlow.xml"), 89, 12));
			}
		}

		@Override
		public int onFlowEvent(Event event) throws Exception {
			int eventResult;
			int count;
			// Line: 93
			try {
				count = getCount(305808283) + 1;
				if (event.triggers("sense.user.speak")) {
					if (event.has("sem:confirm")) {
						incrCount(305808283);
						eventResult = EVENT_CONSUMED;
						EXECUTION: {
							// Line: 94
							Timer state28 = new Timer();
							flowThread.gotoState(state28, currentState, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\Niklas\\IrisTK\\app\\kitchenMaid\\src\\iristk\\app\\kitchenMaid\\RecipeFlow.xml"), 94, 24)));
							eventResult = EVENT_ABORTED;
							break EXECUTION;
						}
						if (eventResult != EVENT_IGNORED) return eventResult;
					}
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("C:\\Users\\Niklas\\IrisTK\\app\\kitchenMaid\\src\\iristk\\app\\kitchenMaid\\RecipeFlow.xml"), 93, 62));
			}
			// Line: 96
			try {
				count = getCount(292938459) + 1;
				if (event.triggers("sense.user.speak")) {
					if (event.has("sem:no")) {
						incrCount(292938459);
						eventResult = EVENT_CONSUMED;
						EXECUTION: {
							iristk.flow.DialogFlow.say state29 = new iristk.flow.DialogFlow.say();
							StringCreator string30 = new StringCreator();
							string30.append("You need to set a timer for this part.");
							state29.setText(string30.toString());
							if (!flowThread.callState(state29, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\Niklas\\IrisTK\\app\\kitchenMaid\\src\\iristk\\app\\kitchenMaid\\RecipeFlow.xml"), 96, 57)))) {
								eventResult = EVENT_ABORTED;
								break EXECUTION;
							}
							// Line: 98
							startTimer state31 = new startTimer();
							flowThread.gotoState(state31, currentState, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\Niklas\\IrisTK\\app\\kitchenMaid\\src\\iristk\\app\\kitchenMaid\\RecipeFlow.xml"), 98, 30)));
							eventResult = EVENT_ABORTED;
							break EXECUTION;
						}
						if (eventResult != EVENT_IGNORED) return eventResult;
					}
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("C:\\Users\\Niklas\\IrisTK\\app\\kitchenMaid\\src\\iristk\\app\\kitchenMaid\\RecipeFlow.xml"), 96, 57));
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
			// Line: 103
			try {
				EXECUTION: {
					int count = getCount(405662939) + 1;
					incrCount(405662939);
					iristk.flow.DialogFlow.say state32 = new iristk.flow.DialogFlow.say();
					StringCreator string33 = new StringCreator();
					string33.append("Setting timer for");
					state32.setText(string33.toString());
					if (!flowThread.callState(state32, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\Niklas\\IrisTK\\app\\kitchenMaid\\src\\iristk\\app\\kitchenMaid\\RecipeFlow.xml"), 103, 12)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					iristk.flow.DialogFlow.say state34 = new iristk.flow.DialogFlow.say();
					state34.setText(instruction.getAmount());
					if (!flowThread.callState(state34, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\Niklas\\IrisTK\\app\\kitchenMaid\\src\\iristk\\app\\kitchenMaid\\RecipeFlow.xml"), 103, 12)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					iristk.flow.DialogFlow.say state35 = new iristk.flow.DialogFlow.say();
					state35.setText(instruction.getMeasurement());
					if (!flowThread.callState(state35, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\Niklas\\IrisTK\\app\\kitchenMaid\\src\\iristk\\app\\kitchenMaid\\RecipeFlow.xml"), 103, 12)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					// Line: 107
					instruction.setTimer();
					// Line: 108
					timerReady state36 = new timerReady();
					flowThread.gotoState(state36, currentState, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\Niklas\\IrisTK\\app\\kitchenMaid\\src\\iristk\\app\\kitchenMaid\\RecipeFlow.xml"), 108, 31)));
					eventResult = EVENT_ABORTED;
					break EXECUTION;
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("C:\\Users\\Niklas\\IrisTK\\app\\kitchenMaid\\src\\iristk\\app\\kitchenMaid\\RecipeFlow.xml"), 103, 12));
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


	private class timerReady extends State {

		final State currentState = this;


		@Override
		public void setFlowThread(FlowRunner.FlowThread flowThread) {
			super.setFlowThread(flowThread);
		}

		@Override
		public void onentry() throws Exception {
			int eventResult;
			Event event = new Event("state.enter");
			// Line: 113
			try {
				EXECUTION: {
					int count = getCount(123961122) + 1;
					incrCount(123961122);
					iristk.flow.DialogFlow.listen state37 = new iristk.flow.DialogFlow.listen();
					if (!flowThread.callState(state37, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\Niklas\\IrisTK\\app\\kitchenMaid\\src\\iristk\\app\\kitchenMaid\\RecipeFlow.xml"), 113, 12)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					// Line: 115
					if (instruction.isTimerReady()) {
						iristk.flow.DialogFlow.say state38 = new iristk.flow.DialogFlow.say();
						StringCreator string39 = new StringCreator();
						string39.append("Times up!!! Lets move on");
						state38.setText(string39.toString());
						if (!flowThread.callState(state38, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\Niklas\\IrisTK\\app\\kitchenMaid\\src\\iristk\\app\\kitchenMaid\\RecipeFlow.xml"), 115, 42)))) {
							eventResult = EVENT_ABORTED;
							break EXECUTION;
						}
						// Line: 117
						MoveOn state40 = new MoveOn();
						flowThread.gotoState(state40, currentState, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\Niklas\\IrisTK\\app\\kitchenMaid\\src\\iristk\\app\\kitchenMaid\\RecipeFlow.xml"), 117, 27)));
						eventResult = EVENT_ABORTED;
						break EXECUTION;
						// Line: 118
					} else {
						// Line: 119
						timerReady state41 = new timerReady();
						flowThread.gotoState(state41, currentState, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\Niklas\\IrisTK\\app\\kitchenMaid\\src\\iristk\\app\\kitchenMaid\\RecipeFlow.xml"), 119, 31)));
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("C:\\Users\\Niklas\\IrisTK\\app\\kitchenMaid\\src\\iristk\\app\\kitchenMaid\\RecipeFlow.xml"), 113, 12));
			}
		}

		@Override
		public int onFlowEvent(Event event) throws Exception {
			int eventResult;
			int count;
			// Line: 122
			try {
				count = getCount(1910163204) + 1;
				if (event.triggers("sense.user.speak")) {
					if (event.has("sem:no")) {
						incrCount(1910163204);
						eventResult = EVENT_CONSUMED;
						EXECUTION: {
							iristk.flow.DialogFlow.say state42 = new iristk.flow.DialogFlow.say();
							StringCreator string43 = new StringCreator();
							string43.append("It's");
							state42.setText(string43.toString());
							if (!flowThread.callState(state42, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\Niklas\\IrisTK\\app\\kitchenMaid\\src\\iristk\\app\\kitchenMaid\\RecipeFlow.xml"), 122, 57)))) {
								eventResult = EVENT_ABORTED;
								break EXECUTION;
							}
							iristk.flow.DialogFlow.say state44 = new iristk.flow.DialogFlow.say();
							state44.setText(instruction.getSeconds());
							if (!flowThread.callState(state44, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\Niklas\\IrisTK\\app\\kitchenMaid\\src\\iristk\\app\\kitchenMaid\\RecipeFlow.xml"), 122, 57)))) {
								eventResult = EVENT_ABORTED;
								break EXECUTION;
							}
							iristk.flow.DialogFlow.say state45 = new iristk.flow.DialogFlow.say();
							StringCreator string46 = new StringCreator();
							string46.append("seconds left");
							state45.setText(string46.toString());
							if (!flowThread.callState(state45, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\Niklas\\IrisTK\\app\\kitchenMaid\\src\\iristk\\app\\kitchenMaid\\RecipeFlow.xml"), 122, 57)))) {
								eventResult = EVENT_ABORTED;
								break EXECUTION;
							}
						}
						if (eventResult != EVENT_IGNORED) return eventResult;
					}
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("C:\\Users\\Niklas\\IrisTK\\app\\kitchenMaid\\src\\iristk\\app\\kitchenMaid\\RecipeFlow.xml"), 122, 57));
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
			// Line: 130
			try {
				EXECUTION: {
					int count = getCount(758529971) + 1;
					incrCount(758529971);
					// Line: 131
					animation.setTalk();
					iristk.flow.DialogFlow.say state47 = new iristk.flow.DialogFlow.say();
					StringCreator string48 = new StringCreator();
					string48.append("Let me know when you are ready");
					state47.setText(string48.toString());
					if (!flowThread.callState(state47, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\Niklas\\IrisTK\\app\\kitchenMaid\\src\\iristk\\app\\kitchenMaid\\RecipeFlow.xml"), 130, 11)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					// Line: 133
					animation.setListen();
					iristk.flow.DialogFlow.listen state49 = new iristk.flow.DialogFlow.listen();
					if (!flowThread.callState(state49, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\Niklas\\IrisTK\\app\\kitchenMaid\\src\\iristk\\app\\kitchenMaid\\RecipeFlow.xml"), 130, 11)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("C:\\Users\\Niklas\\IrisTK\\app\\kitchenMaid\\src\\iristk\\app\\kitchenMaid\\RecipeFlow.xml"), 130, 11));
			}
		}

		@Override
		public int onFlowEvent(Event event) throws Exception {
			int eventResult;
			int count;
			// Line: 136
			try {
				count = getCount(1940030785) + 1;
				if (event.triggers("sense.user.speak")) {
					if (event.has("sem:ready")) {
						incrCount(1940030785);
						eventResult = EVENT_CONSUMED;
						EXECUTION: {
							// Line: 137
							animation.setTalk();
							// Line: 138
							boolean chosen50 = false;
							boolean matching51 = true;
							while (!chosen50 && matching51) {
								int rand52 = random(1763847188, 3, iristk.util.RandomList.RandomModel.DECK_RESHUFFLE_NOREPEAT);
								matching51 = false;
								if (true) {
									matching51 = true;
									if (rand52 >= 0 && rand52 < 1) {
										chosen50 = true;
										iristk.flow.DialogFlow.say state53 = new iristk.flow.DialogFlow.say();
										StringCreator string54 = new StringCreator();
										string54.append("Good, lets move on");
										state53.setText(string54.toString());
										if (!flowThread.callState(state53, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\Niklas\\IrisTK\\app\\kitchenMaid\\src\\iristk\\app\\kitchenMaid\\RecipeFlow.xml"), 138, 11)))) {
											eventResult = EVENT_ABORTED;
											break EXECUTION;
										}
									}
								}
								if (true) {
									matching51 = true;
									if (rand52 >= 1 && rand52 < 2) {
										chosen50 = true;
										iristk.flow.DialogFlow.say state55 = new iristk.flow.DialogFlow.say();
										StringCreator string56 = new StringCreator();
										string56.append("Awesome, time for the next step");
										state55.setText(string56.toString());
										if (!flowThread.callState(state55, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\Niklas\\IrisTK\\app\\kitchenMaid\\src\\iristk\\app\\kitchenMaid\\RecipeFlow.xml"), 138, 11)))) {
											eventResult = EVENT_ABORTED;
											break EXECUTION;
										}
									}
								}
								if (true) {
									matching51 = true;
									if (rand52 >= 2 && rand52 < 3) {
										chosen50 = true;
										iristk.flow.DialogFlow.say state57 = new iristk.flow.DialogFlow.say();
										StringCreator string58 = new StringCreator();
										string58.append("Whoop whoop moving on");
										state57.setText(string58.toString());
										if (!flowThread.callState(state57, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\Niklas\\IrisTK\\app\\kitchenMaid\\src\\iristk\\app\\kitchenMaid\\RecipeFlow.xml"), 138, 11)))) {
											eventResult = EVENT_ABORTED;
											break EXECUTION;
										}
									}
								}
							}
							// Line: 143
							MoveOn state59 = new MoveOn();
							flowThread.gotoState(state59, currentState, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\Niklas\\IrisTK\\app\\kitchenMaid\\src\\iristk\\app\\kitchenMaid\\RecipeFlow.xml"), 143, 25)));
							eventResult = EVENT_ABORTED;
							break EXECUTION;
						}
						if (eventResult != EVENT_IGNORED) return eventResult;
					}
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("C:\\Users\\Niklas\\IrisTK\\app\\kitchenMaid\\src\\iristk\\app\\kitchenMaid\\RecipeFlow.xml"), 136, 59));
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
			// Line: 148
			try {
				count = getCount(1192108080) + 1;
				if (event.triggers("sense.user.silence")) {
					incrCount(1192108080);
					eventResult = EVENT_CONSUMED;
					EXECUTION: {
						// Line: 149
						animation.setTalk();
						iristk.flow.DialogFlow.say state60 = new iristk.flow.DialogFlow.say();
						StringCreator string61 = new StringCreator();
						string61.append("How is it going");
						state60.setText(string61.toString());
						if (!flowThread.callState(state60, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\Niklas\\IrisTK\\app\\kitchenMaid\\src\\iristk\\app\\kitchenMaid\\RecipeFlow.xml"), 148, 38)))) {
							eventResult = EVENT_ABORTED;
							break EXECUTION;
						}
						// Line: 151
						flowThread.reentryState(this, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\Niklas\\IrisTK\\app\\kitchenMaid\\src\\iristk\\app\\kitchenMaid\\RecipeFlow.xml"), 151, 14)));
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					if (eventResult != EVENT_IGNORED) return eventResult;
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("C:\\Users\\Niklas\\IrisTK\\app\\kitchenMaid\\src\\iristk\\app\\kitchenMaid\\RecipeFlow.xml"), 148, 38));
			}
			// Line: 153
			try {
				count = getCount(537548559) + 1;
				if (event.triggers("sense.user.speak")) {
					incrCount(537548559);
					eventResult = EVENT_CONSUMED;
					EXECUTION: {
						// Line: 154
						animation.setTalk();
						iristk.flow.DialogFlow.say state62 = new iristk.flow.DialogFlow.say();
						StringCreator string63 = new StringCreator();
						string63.append("I am sorry, I didn't get that.");
						state62.setText(string63.toString());
						if (!flowThread.callState(state62, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\Niklas\\IrisTK\\app\\kitchenMaid\\src\\iristk\\app\\kitchenMaid\\RecipeFlow.xml"), 153, 36)))) {
							eventResult = EVENT_ABORTED;
							break EXECUTION;
						}
						// Line: 156
						flowThread.reentryState(this, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\Niklas\\IrisTK\\app\\kitchenMaid\\src\\iristk\\app\\kitchenMaid\\RecipeFlow.xml"), 156, 14)));
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					if (eventResult != EVENT_IGNORED) return eventResult;
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("C:\\Users\\Niklas\\IrisTK\\app\\kitchenMaid\\src\\iristk\\app\\kitchenMaid\\RecipeFlow.xml"), 153, 36));
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
			// Line: 161
			try {
				EXECUTION: {
					int count = getCount(1451270520) + 1;
					incrCount(1451270520);
					// Line: 162
					animation.setTalk();
					iristk.flow.DialogFlow.say state64 = new iristk.flow.DialogFlow.say();
					StringCreator string65 = new StringCreator();
					string65.append("Let me repeat the amount");
					state64.setText(string65.toString());
					if (!flowThread.callState(state64, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\Niklas\\IrisTK\\app\\kitchenMaid\\src\\iristk\\app\\kitchenMaid\\RecipeFlow.xml"), 161, 12)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					iristk.flow.DialogFlow.say state66 = new iristk.flow.DialogFlow.say();
					state66.setText(instruction.getMeasurement());
					if (!flowThread.callState(state66, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\Niklas\\IrisTK\\app\\kitchenMaid\\src\\iristk\\app\\kitchenMaid\\RecipeFlow.xml"), 161, 12)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					// Line: 165
					Wait state67 = new Wait();
					flowThread.gotoState(state67, currentState, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\Niklas\\IrisTK\\app\\kitchenMaid\\src\\iristk\\app\\kitchenMaid\\RecipeFlow.xml"), 165, 24)));
					eventResult = EVENT_ABORTED;
					break EXECUTION;
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("C:\\Users\\Niklas\\IrisTK\\app\\kitchenMaid\\src\\iristk\\app\\kitchenMaid\\RecipeFlow.xml"), 161, 12));
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
			// Line: 170
			try {
				EXECUTION: {
					int count = getCount(1297685781) + 1;
					incrCount(1297685781);
					// Line: 171
					animation.setTalk();
					iristk.flow.DialogFlow.say state68 = new iristk.flow.DialogFlow.say();
					StringCreator string69 = new StringCreator();
					string69.append("Let me repeat the ingredient");
					state68.setText(string69.toString());
					if (!flowThread.callState(state68, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\Niklas\\IrisTK\\app\\kitchenMaid\\src\\iristk\\app\\kitchenMaid\\RecipeFlow.xml"), 170, 12)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					iristk.flow.DialogFlow.say state70 = new iristk.flow.DialogFlow.say();
					state70.setText(instruction.getIngredient());
					if (!flowThread.callState(state70, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\Niklas\\IrisTK\\app\\kitchenMaid\\src\\iristk\\app\\kitchenMaid\\RecipeFlow.xml"), 170, 12)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					// Line: 174
					Wait state71 = new Wait();
					flowThread.gotoState(state71, currentState, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\Niklas\\IrisTK\\app\\kitchenMaid\\src\\iristk\\app\\kitchenMaid\\RecipeFlow.xml"), 174, 24)));
					eventResult = EVENT_ABORTED;
					break EXECUTION;
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("C:\\Users\\Niklas\\IrisTK\\app\\kitchenMaid\\src\\iristk\\app\\kitchenMaid\\RecipeFlow.xml"), 170, 12));
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
			// Line: 179
			try {
				EXECUTION: {
					int count = getCount(1252585652) + 1;
					incrCount(1252585652);
					// Line: 180
					animation.setTalk();
					iristk.flow.DialogFlow.say state72 = new iristk.flow.DialogFlow.say();
					StringCreator string73 = new StringCreator();
					string73.append("Okay, goodbye");
					state72.setText(string73.toString());
					if (!flowThread.callState(state72, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\Niklas\\IrisTK\\app\\kitchenMaid\\src\\iristk\\app\\kitchenMaid\\RecipeFlow.xml"), 179, 12)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					// Line: 182
					System.exit(0);
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("C:\\Users\\Niklas\\IrisTK\\app\\kitchenMaid\\src\\iristk\\app\\kitchenMaid\\RecipeFlow.xml"), 179, 12));
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
